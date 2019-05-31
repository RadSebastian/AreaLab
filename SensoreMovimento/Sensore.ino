int Sensore =  0;
int pinporta = 8;
void setup() {
  Serial.begin(9600);
  pinMode(pinporta, INPUT);
}


void loop() {
  Sensore = digitalRead(pinporta);
  if(Sensore == 1)
     Serial.println("PIR ATTIVO");
  else
    Serial.println("PIR SPENTO");
    
  delay(3000);

}
