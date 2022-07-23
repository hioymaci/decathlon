package com.kuehnenagel.writer;

import com.kuehnenagel.Athlete;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Write athletes in xml format.
 */
public class XmlAthleteWriter implements AthleteWriter {

    private static final Logger log = Logger.getLogger((XmlAthleteWriter.class.getName()));

    private static final String XML_ROOT_TAG_NAME = "athletes_ranking";
    private static final String ATHLETE_TAG_NAME = "athlete";
    private static final String PLACE_TAG_NAME = "place";
    private static final String SCORE_TAG_NAME = "score";
    private static final String FULL_NAME_TAG_NAME = "fullName";

    private static void writeXml(Document doc, OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);
    }

    @Override
    public void writeToFileAsSorted(Map<Integer, List<Athlete>> athleteMap, File outputFile, int numberOfAthlete) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
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
        for (Map.Entry<Integer, List<Athlete>> entry : athleteMap.entrySet()) {
            List<Athlete> athleteList = athleteMap.get(entry.getKey());
            StringBuilder placeSb = new StringBuilder();
            for (int i = athleteList.size() - 1; i >= 0; --i) {
                placeSb.append(place - i).append("-");
            }
            placeSb.deleteCharAt(placeSb.length() - 1);
            place -= athleteList.size();

            for (Athlete athlete : athleteList) {
                Element athleteElem = doc.createElement(ATHLETE_TAG_NAME);
                athleteElem.setAttribute(PLACE_TAG_NAME, String.valueOf(placeSb.toString()));
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
