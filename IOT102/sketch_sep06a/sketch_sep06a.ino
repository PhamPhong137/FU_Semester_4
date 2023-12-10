/*
  Blink - Nhấp nháy
  Đoạn code làm nhấp nháy một đèn LED cho trước
 */
 
// chân digital 13 cần được kết nối với đèn LED
// và chân digital 13 này sẽ được đặt tên là 'led'. Biến 'led' này có kiểu dữ liệu là int và có giá trị là 13
int led1 = 12;
int led2 = 11;
int led3 = 10;
int led4 = 9;

 
// Hàm setup chạy một lần duy nhất khi khởi động chương trình
void setup() {                
  // đặt 'led' là OUTPUT
  pinMode(led1, OUTPUT);    
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);
  
}
 
// Hàm loop chạy mãi mãi sau khi kết thúc hàm setup()
void loop() {
  digitalWrite(led1, HIGH);   // bật đèn led sáng
  delay(1000);               // dừng chương trình trong 1 giây => thây đèn sáng được 1 giây
  digitalWrite(led1, LOW);    // tắt đèn led
  delay(1000);               // dừng chương trình trong 1 giây => thấy đèn tối được 1 giây
  digitalWrite(led2, HIGH);   // bật đèn led sáng
  delay(1000);               // dừng chương trình trong 1 giây => thây đèn sáng được 1 giây
  digitalWrite(led2, LOW);    // tắt đèn led
  delay(1000);
  digitalWrite(led3, HIGH);   // bật đèn led sáng
  delay(1000);               // dừng chương trình trong 1 giây => thây đèn sáng được 1 giây
  digitalWrite(led3, LOW);    // tắt đèn led
  delay(1000);
  digitalWrite(led4, HIGH);   // bật đèn led sáng
  delay(1000);               // dừng chương trình trong 1 giây => thây đèn sáng được 1 giây
  digitalWrite(led4, LOW);    // tắt đèn led
  delay(1000);
}
