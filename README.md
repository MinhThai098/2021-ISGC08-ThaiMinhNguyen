# 2021-ISGC08-ThaiMinhNguyen
Kurs ISGC08
## Gruppmedlemmar

| Namn | Roll        
| ------------- |-------------
| Thai Minh Nguyen   | Repo admin och utvecklare 
| Mathias Rajamäki   |  utvecklare     
| Benneth Christiansson | Examinator och handledare   

### Kravspecifikation:
Laborationen går ut på att bygga en komplett texteditor med ett grafiskt användargränssnitt i Java användande Swing.

Utgå ifrån programmet anteckningar (notepad) följande features ska implementeras:


Kompletta textredigeringsmöjligheter: skriva in text, klippa ut, klistra in och kopiera (behöver ej implementeras i meny, det räcker om kortkommandona CTRL-X, CTRL-C, CTRL-V fungerar)


Lagring kan ske i valfritt format men ska lagras till fil
File (Arkivmenyn) med

Open

New

Save

Save As samt

Exit

### Designkrav
Ska följa MVC-strukturen med definierade gränssnitt.

Lagring ska ske i vanliga textfiler (unicode)

Design modellen ska innehålla Use-case diagram, klassdiagram (alla attribut med datatyp, metoder med signaturer samt alla relationsattribut) samt sekvensdiagram ska även definiera de gränssnitt som ska användas för att uppfylla MVC. Använd vilka verktyg ni vill men diagrammen ska vara synliga och läsbara i wikin.

## Resultat från Design
### Use Case diagram
![image](https://user-images.githubusercontent.com/65395551/142213877-efe7eae9-2be9-4a08-9beb-280e2c8a7f6d.png)


### Klassdiagram
![image](https://user-images.githubusercontent.com/65395551/142213939-6f0362b6-5e63-4e20-8a2d-bb62e1791a38.png)

### Sekvensdiagram

#### Write Text Sekvens
![image](https://user-images.githubusercontent.com/65395551/142214760-7a3f071b-d8ea-4586-b6eb-4e2643ed700c.png)

#### Copy Text Sekvens
![image](https://user-images.githubusercontent.com/65395551/142214801-c6b41f78-4ebc-4419-a0db-f52069eeeef2.png)

#### Paste Text Sekvens
![image](https://user-images.githubusercontent.com/65395551/142214868-3aac30bd-708d-4162-b593-53751e3c64a3.png)

#### Cut Text Sekvens
![image](https://user-images.githubusercontent.com/65395551/142214887-17d55433-7fe6-4d48-99fb-3a96b06fb899.png)

#### Save File As Sekvens
![image](https://user-images.githubusercontent.com/65395551/142214939-25cf4ee7-0b0a-4644-86b0-6a31ceba48ac.png)

#### Save File Sekvens
![image](https://user-images.githubusercontent.com/65395551/142214974-89ff6371-5420-4194-aaac-28086c8f0ceb.png)

#### Open File Sekvens
![image](https://user-images.githubusercontent.com/65395551/142215006-972fb0d8-214e-4408-b43c-820360b021f5.png)

#### Exit Sekvens
![image](https://user-images.githubusercontent.com/65395551/142215037-04f95944-7c52-42e0-84d1-b85f7a7d8d92.png)


