// doc du lieu tu bien tro ve man hinh may tinh
#include <Servo.h>
Servo myservo;
int dientroquang = A0;
int a = 0;
void setup() {
  myservo.attach(9);
  Serial.begin(9600);//9600 chuan truyen thong qua usb
  
}
void loop() {
  a = analogRead(dientroquang);
  Serial.print("gia tri dien tro quang = ");
  Serial.println(a);

  if(a>500){
    myservo.write(0);
    delay(300);
  }else{              
    myservo.write(0);
  }
  delay(1000);
  
 
}
