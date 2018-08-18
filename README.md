# Blueprint Power Consumption Calculator

Usage:
`java -jar BPCC.jar [BLUEPRINT STRING]`

Output:
`Max. Power Consumption: 36.1 MW`

Requirements:
* Java 8
* Factorio 0.16.x
* Windows / Linux / MacOS

Dependencies:
* Gson 2.8.5

Notes:
* Modules are ignored

Important:

Windows users are advised to use the PowerShell instead of the Command Prompt (CMD). Because the CMD has a limit on the characters you can paste into it, using a large blueprint (long blueprint string) can result in the string not being pasted in it's entirety, therefore passing an incomplete string to the application which will throw an error.
