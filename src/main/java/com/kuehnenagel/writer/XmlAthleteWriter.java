package com.kuehnenagel.writer;

import com.kuehnenagel.Athlete;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Write athletes in xml format.
 */
public class XmlAthleteWriter implements AthleteWriter {

    private static final Logger log = Logger.getLogger(XmlAthleteWriter.class.getName());

    private static final String XML_ROOT_TAG_NAME = "athletes_ranking";
    private static final String ATHLETE_TAG_NAME = "athlete";

    // first letter is especially capital because it is written in first order in attribute list
    private static final String PLACE_TAG_NAME = "Place";
    private static final String SCORE_TAG_NAME = "Score";
    private static final String FULL_NAME_TAG_NAME = "fullName";

    private static void writeXml(Document doc, OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        // to be compliant, prohibit the use of all protocols by external entities:
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);
    }

    @Override
    public void writeToFileAsSorted(Map<Integer, Set<Athlete>> athleteMap, File outputFile, int numberOfAthlete) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

        // root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement(XML_ROOT_TAG_NAME);
        doc.appendChild(rootElement);


        int place = numberOfAthlete;
        for (Map.Entry<Integer, Set<Athlete>> entry : athleteMap.entrySet()) {
            Set<Athlete> athleteList = athleteMap.get(entry.getKey());
            String placeStr;
            if (athleteList.size() > 1) {
                placeStr = String.format("%d-%d", place - athleteList.size() + 1, place);
            } else {
                placeStr = String.valueOf(place);
            }
            place -= athleteList.size();

            for (Athlete athlete : athleteList) {
                Element athleteElem = doc.createElement(ATHLETE_TAG_NAME);
                athleteElem.setAttribute(PLACE_TAG_NAME, placeStr);
                athleteElem.setAttribute(SCORE_TAG_NAME, String.valueOf(entry.getKey()));
                athleteElem.setAttribute(FULL_NAME_TAG_NAME, athlete.getFullName());
                rootElement.appendChild(athleteElem);
            }
        }

        try (FileOutputStream output = new FileOutputStream(outputFile)) {
            writeXml(doc, output);
        } catch (IOException | TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
