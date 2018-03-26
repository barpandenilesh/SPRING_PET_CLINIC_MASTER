set projectlocation= D:\SPRING_PET_CLINIC_MASTER\spring-petclinic-master
cd %projectlocation%
set classpath=%projectlocation%\lib\*;%projectlocation%target\test-classes
java org.testng.TestNG %projectLocation%\testng.xml
pause