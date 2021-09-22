JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Main.java \
	CargoBay.java \
	Employee.java \
	MaintenanceEmployee.java \
	SecurityEmployee.java \
	CleaningEmployee.java \
	EquipmentCompartment.java \
	PassengerCompartment.java \
	PlaneComponent.java \
	PrivateCompartment.java \
	Plane.java \
	
	
default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
