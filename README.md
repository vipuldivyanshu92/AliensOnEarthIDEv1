AliensOnEarthIDEv1
==================

Aliens Registration System IDE VERSION

To run this just import the project in Eclipse or your suitable IDE Keep in mind to keep the same structure And then just run.

The exported output files are inside the java projects root directory ie, inside AliensOnEarth directory

Adding plugins for export format

1. add the new export format lass to the sources folder

2. add the display name string for that export format in Utils.java in the createExportMenu string array at the end

3. add a case statement invoking the export function and pass the values variable(it holds alineds reg. data) inside the createExportMenu function of Main.java
