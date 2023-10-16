Feature: Create, Edit and Delete Time and Material Record

  Background:
    Given User  should be logged in to turnup portal
    And User Should navigate to time and material page

  Scenario Outline: Create a new time and material record

    When Create a new time and material record "<Code>" "<Description>" "<Price>"
    Then The record should be created successfully "<Code>"

    Examples:
      | Code        | Description      | Price |
      | CodeCreated    | NewDescription  | 114.20  |

  Scenario Outline: Edit an existing time and material record

    When Edit an existing time and material record "<UpdatedCode>" "<UpdatedDescription>" "<UpdatedPrice>"
    Then The record should be updated successfully "<UpdatedCode>"

    Examples:
      | UpdatedCode  | UpdatedDescription | UpdatedPrice   |
      | Code Edited | Description Edited    | 768.98 |

  Scenario Outline: Delete time and material record
    When Delete an existing time and material record
    Then The record should be deleted successfully "<UpdatedCode>"
    Examples:
    |UpdatedCode|
    |Code Edited|
