test:
	javac Test.java
	java Test

jar:
	mkdir dist
	jar cvf dist/opre.jar opre

# linux only
clean:
	find . -type f -name "*.class"
	find . -type f -name "*.class" -delete

.PHONY: test jar clean
