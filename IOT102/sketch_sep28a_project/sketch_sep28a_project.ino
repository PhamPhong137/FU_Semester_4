#include <LiquidCrystal.h>

LiquidCrystal lcd(1, 2, 4, 5, 6, 7);
const int trigPin = 9;
const int echoPin = 10;
int buzzer = 11;
int ledPin = 13;
int button = 3;
long duration;
int distance;
int safetyDistance;
int potPin = A0; 
int potValue;
int trangthaibutton = LOW;
int lastButtonState = LOW;
unsigned long lastDebounceTime = 0;
const int DEBOUNCE_DELAY = 1; 
int count = 0;

void setup() {
  lcd.begin(16, 2);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  pinMode(buzzer, OUTPUT);
  pinMode(ledPin, OUTPUT);
  pinMode(potPin, INPUT);
  pinMode(button, INPUT);
 // Serial.begin(9600);
}

void loop() {
  int reading = digitalRead(button);
  
  if (reading != lastButtonState) {
    lastDebounceTime = millis();
  }

  if ((millis() - lastDebounceTime) > DEBOUNCE_DELAY) {
    if (reading != trangthaibutton) {
      trangthaibutton = reading;

      if (trangthaibutton == HIGH) {
        count++;
      }
    }
  }

  lastButtonState = reading;

  if (count % 2 == 0) {
    // Phần xử lý cảm biến khoảng cách và cảnh báo
    digitalWrite(trigPin, LOW);
    delayMicroseconds(2);
    digitalWrite(trigPin, HIGH);
    delayMicroseconds(10);
    digitalWrite(trigPin, LOW);

    duration = pulseIn(echoPin, HIGH);
    distance = duration * 0.034 / 2;

    potValue = analogRead(potPin);
    safetyDistance = map(potValue, 0, 1023, 5, 100);
    //Serial.print(safetyDistance);
    lcd.setCursor(0, 1);
    lcd.print("Distance: ");
    lcd.print(distance);
    lcd.print(" cm   ");  // Thêm khoảng trắng để xóa ký tự thừa
    lcd.setCursor(0, 0);
    lcd.print("Safety: ");
    lcd.print(safetyDistance);
    lcd.print(" cm   ");  // Thêm khoảng trắng để xóa ký tự thừa

    if (distance <= safetyDistance) {
      digitalWrite(buzzer, HIGH);
      digitalWrite(ledPin, HIGH);      
    } else {
      digitalWrite(buzzer, LOW);
      digitalWrite(ledPin, 0);
    }
  } else {
    digitalWrite(buzzer, LOW);
    digitalWrite(ledPin, 0);
  }
  delay(1);
}
