all:
	javac -d build src/tradingCardProject/*
run:
	java -cp build/ tradingCardProject.MainGUI
