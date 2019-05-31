#include "DHT.h"
#define DHTPIN 8
// 8 è il pin di Arduino a cui collego il sensore di temperatura
#define DHTTYPE DHT11
// dht11 è il tipo di sensore che uso
DHT dht(DHTPIN, DHTTYPE);
#include <SPI.h>
#include <SD.h>

File myFile;
 
void setup() {
  Serial.begin(9600);
  dht.begin();
}
void loop() {
int t = dht.readTemperature();
int h = dht.readHumidity();
// posiziono il cursore alla colonna 12 e riga 0

Serial.print("\n\nTemperature: ");
Serial.print(t);
Serial.print("\nHumidity: ");
Serial.print(h);
delay(5000);

Serial.println("Creating example.txt...");
  myFile = SD.open("example.txt", FILE_WRITE);
  myFile.close();
}
