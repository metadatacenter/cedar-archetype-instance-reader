package org.metadatacenter.archetype;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Take a jsonschema2pojo-generated Java class generated from a CEDAR template and read a template instance
 * conforming to that template.
 */
public class TemplateInstanceReader
{
  public static void main(String[] argc) throws IOException
  {
    ObjectMapper mapper = new ObjectMapper();
    File studyTemplateInstanceJSONFile = new File(
      TemplateInstanceReader.class.getClassLoader().getResource("./json/studyTemplateInstance.json").getFile());

    StudyTemplate study = mapper.readValue(studyTemplateInstanceJSONFile, StudyTemplate.class);

    System.out.println("Study name: " + study.getStudyName().getValue());
    System.out.println("Disease: " + study.getDisease().getValue());
    System.out.println("Organism: " + study.getOrganism().getValue());

    Institution institution = study.getInstitution();
    System.out.println("Institution name: " + institution.getInstitutionName().getValue());

    Address address = institution.getAddress();
    System.out.println("Address 1: " + address.getAddress1().getValue());
    System.out.println("Address 2: " + address.getAddress2().getValue());
    System.out.println("Town: " + address.getTown().getValue());
    System.out.println("ZIP/Postal Code" + address.getZIPPostalCode().getValue());
    System.out.println("Country: " + address.getCountry().getValue());

    List<Publication> publications = study.getPublication();
    for (Publication publication : publications) {
      System.out.println("Title: " + publication.getPublicationTitle().getValue());
      List<Author> authors = publication.getAuthor();
      for (Author author : authors)
        System.out.println("Author: " + author.getValue());

      System.out.println("Publication Type: " + publication.getPublicationType().getValue());
      System.out.println("Year Published: " + publication.getYearPublished().getValue());
    }
  }
}
