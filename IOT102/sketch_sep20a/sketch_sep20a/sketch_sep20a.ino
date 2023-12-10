int buttonA = 6;
int buttonB = 9;
int trangthaiA, trangthaiB;
void setup() {
  // put your setup code here, to run once:
  pinMode(buttonA, INPUT);
   pinMode(buttonB, INPUT);
   pinMode(12, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  trangthaiA = digitalRead(buttonA);
trangthaiB = digitalRead(buttonB);
  if(trangthaiA==1){
    digitalWrite(12,1);
  }
  if(trangthaiB==1){
    digitalWrite(12,0);
  }
  
}
