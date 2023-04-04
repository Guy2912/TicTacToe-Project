# วิธีการติดตั้ง
##### เพื่อเขียนโปรแกรม Java บนเครื่องของคุณ คุณต้องทำการติดตั้ง Java Development Kit (JDK) ก่อน โดยมีขั้นตอนดังนี้:
##### 1.ดาวน์โหลด JDK จากเว็บไซต์ของ Oracle หรือ OpenJDK จากเว็บไซต์อื่นๆ
##### 2.เปิดไฟล์ติดตั้ง JDK ที่คุณดาวน์โหลดมา และทำการติดตั้งโดยปกติ
##### 3.เมื่อติดตั้งเสร็จสิ้น ให้ตรวจสอบว่า JDK ได้ถูกติดตั้งเรียบร้อยแล้วโดยเปิด Command Prompt หรือ Terminal แล้วพิมพ์คำสั่ง java -version เพื่อตรวจสอบเวอร์ชันของ JDK ที่ติดตั้งไว้
##### 4.เมื่อติดตั้ง JDK เสร็จเรียบร้อยแล้ว คุณสามารถเริ่มเขียนโปรแกรม Java ได้โดยใช้ Text editor หรือ Integrated Development Environment (IDE) เช่น Eclipse, NetBeans, IntelliJ IDEA ซึ่งสามารถดาวน์โหลดได้จากเว็บไซต์ของผู้พัฒนาแต่ละแบบ
##### 5.จากนั้นให้นำ source code ใน GitHub มารันในโปรแกรมที่คุณลงไว้โดยให้รันใน class TicTacToeRunner คุณจะได้หน้าต่าง UI
[![image][[https://ibb.co/FBXLfty](https://imgur.com/t6SPMQh.jpg)]

# วิธีใช้งาน
##### กฎเกม Tic Tac Toe มีดังนี้:
##### 1.เกมนี้เล่นโดยผู้เล่นสองคน โดยคนแรกจะใช้เครื่องหมาย X และคนที่สองจะใช้เครื่องหมาย O
##### 2.เริ่มเกมต้องมีผู้เล่นสองคน โดยจะต้องมีผู้เล่นต่อสู้กัน
##### 3.ผู้เล่นจะวางเครื่องหมายของตนในช่องว่างของกระดาน เริ่มต้นจากผู้เล่นคนใดคนหนึ่ง
##### 4.เมื่อวางเครื่องหมายลงบนกระดานแล้ว ไม่สามารถย้ายหรือลบเครื่องหมายออกจากกระดานได้
##### 5.ผู้เล่นต้องวางเครื่องหมายในช่องที่ว่างอยู่บนกระดาน
##### 6.ผู้เล่นที่สามารถวางเครื่องหมาย 3 ตัวที่ต่อกันแนวตั้ง แนวนอน หรือแนวทแยงซ้ายไปขวา ได้ก่อนผู้เล่นอีกคน จะได้รับการชนะเลิศ และจบเกม
##### 7.หากกระดานเต็มและไม่มีผู้เล่นได้ชนะเลิศ จะเป็นเกมเสม
