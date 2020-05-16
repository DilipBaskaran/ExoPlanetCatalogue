*** The Zip file contains the below files
	* README.txt(this one)
	* CatalogueGrouping.jar 
	* src folder
	* pom.xml file
	* output.json(outputted file on running CatalogueGrouping.jar)

HOW TO RUN THE EXECUTABLE JAR FILE:
-------------------------------------
1. If jre is installed in your machine:
	-------------------------------------
	** Double clicking on the jar file would produce the output as per the current availability from url
	
2. If java is installed in your machine and it is saved in your PATH environment variable
	----------------------------------------------------------------------------------------
	** Go to terminal/command prompt
	** go to folder where jar file is present
	** run "java -jar CatalogueGrouping.jar"
	** you could see the output in command prompt as well as file(output.json) is created in the current folder

3. If any IDE is installed with maven configured:
	-----------------------------------------------
	** Open IDE
	** import the maven project using the option("Existing projects") and select the available pom.xml in the zip file
	** Run the CatalogueRefractor.java file
	** You could confirm that "output.json" file is created in the project folder

Questions
-----------------------------------------------------
1. Why did you make the design choices you made?

[Ans] : i have created Object for Planet, GroupingByYear and the result for easy understanding of the items and following oops principles.

2. What assumptions did you make and why?

[Ans] : 1. attributes starting with Hoststar is considered as the star inside planets and planets having 0/null is considered as orphan
		2. attributes Hoststartempk is considered for hot star and if it is high the planet is the one revolving around it
		3. RadiusJpt is considered for grouping with size