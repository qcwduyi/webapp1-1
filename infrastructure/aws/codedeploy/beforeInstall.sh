#!/bin/bash

wget https://s3.amazonaws.com/rds-downloads/rds-ca-2019-us-east-1.pem
openssl x509 -outform der -in rds-ca-2019-us-east-1.pem -out rds-ca-2019-root.der
yes | keytool -import -alias rds-root -keystore truststore.jks -file rds-ca-2019-root.der -storepass 123456
sudo cp truststore.jks /home/ubuntu/truststore.jks
