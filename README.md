# InviteCustomer

## See Generated Output
See the already generated [output](https://github.com/ruchidash/InviteCustomer/blob/main/src/main/resources/output/output.txt)

## 

## Run and Test
- Clone the repository
- Run all commands from the root directory of the repository

### Compile
```
./mvnw compile
```

### Test
```
./mvnw test
```

### Run
```
./mvnw exec:java -DPROPERTY_TYPE=prod
```

- The output file is created at `./src/main/resources/output/output.txt` for input file `./src/main/resources/input/users.txt`

## Configurations
- You can try out different inputs you can change following properties
at [prod.properties](https://github.com/ruchidash/InviteCustomer/blob/main/src/main/resources/prod.properties) or [test.properties](https://github.com/ruchidash/InviteCustomer/blob/main/src/main/resources/test.properties)
```
intercom_dublin_office_longitude=-6.257664
intercom_dublin_office_latitude=53.339428
input_file_path=src/main/resources/input/
output_file_path=src/main/resources/output/
users_input_file_name=users.txt
users_output_file_name=output.txt
```
- To pick a particular configuration (test/prod) you can pass as JVM system property or set environment variable
`PROPERTY_TYPE=test`
