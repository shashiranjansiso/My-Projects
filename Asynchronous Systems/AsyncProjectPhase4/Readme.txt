Instructions to Compile & Run:
DistAlgo:
1. Copy and extract the zipped file to desktop.
2. Go to DistAlgo src folder and copy the config files from config folder and rename the config file to “config.ini”
3. Execute the following command to compile the chainreplication.da source code:
			python3.4 -m da.compiler chainreplication.da 
4. Run the diet algo code using the following command.
			python3.4 -m da -f chainreplication.da
5. Logs will be generated in the same path with chainreplication.da.log

Main Files:

DistAlgo:
1. src/chainreplication.da
2. config/config.ini

Limitations

DisAlgo
	1. config file should be in same folder where chainreplication.da is copied and with the filename as “config.ini”

Contributions:
Mehak Mehta:
Design and code implementation of normal transfer flow for two banks.
Configuration to generate transfer requests based upon probablity and random choosng of banks
Code debugging and handling error scenarios testing

Shashi Ranjan
Basic transfer flow implementation between two banks.
Head and tail server failures in handling requests and adaptation of code for such scenarios
Debugging and testing of server failure scenarios

