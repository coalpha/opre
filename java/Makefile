test:
	javac test/Test.java
	java test.Test

compile:
	javac Test.java

jar:
	mkdir dist
	jar cvf dist/opre.jar opre

# linux only
clean:
	find . -type f -name "*.class"
	find . -type f -name "*.class" -delete

.PHONY: test jar clean compile
