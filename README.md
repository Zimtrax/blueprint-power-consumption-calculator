# Blueprint Power Consumption Calculator (BPCC)
The BPCC is a small Java application to quickly calculate and view the power consumption of machines, inserters etc. from a blueprint string.

It's fairly easy to use:

`java -jar BPCC.jar [BLUEPRINT STRING]`

After it's done calculating, it will output the estimated maximum power consumption in kW.

It currently does not take any modules into account.

TODO
- [ ] Incorporate modules used into the calculation
