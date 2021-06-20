Made for CSE 472 Information Systems Security 

Made By: Berkcan Altungöz - 20170808014 

Demo Link: https://youtu.be/X1WUSSxe58Y


# !! IMPORTANT !!

---

This project is built and tested with OpenJDK Version 15.0.2 & JavaFX SDK 16 using IntelliJ IDEA Version 2021.1.2 Ultimate Edition


Download OpenJDK Here: https://jdk.java.net/archive/

Download JavaFX Here: https://gluonhq.com/products/javafx/

Installing OpenJDK: https://openjfx.io/openjfx-docs/#install-java

Installing JavaFX: https://openjfx.io/openjfx-docs/#install-javafx

### TO ABLE TO RUN THIS APPLICATION IN YOUR IDE YOU ALSO NEED TO FOLLOW THESE INSTRUCTIONS


**!!!** This application uses **javafx.controls** & **javafx.fxml** modules

#### FOR CLI FOLLOW THIS LINK: https://openjfx.io/openjfx-docs/#install-javafx
#### FOR IntelliJ FOLLOW THIS LINK: https://openjfx.io/openjfx-docs/#IDE-Intellij
#### FOR NetBeans FOLLOW THIS LINK: https://openjfx.io/openjfx-docs/#IDE-NetBeans
#### FOR Eclipse FOLLOW THIS LINK: https://openjfx.io/openjfx-docs/#IDE-Eclipse

After configuring your environment you can run this application by running Main.java in the package Main.

## FINDINGS

---

In this project I wanted to build a cool little application that can be used to encrypt and decrypt messages. 
Since I was very interested in the Enigma Machine used by Germans in WW2 to encrypt their messages in the battlefield which eventually led to Alan Turing cracking the code using a machine which became one of the biggest events in computer engineering history.

I wanted to implement this machine to see how it really functioned. It can be used as a fun little application messaging between eachother by giving the configurations to the machine.
Because this encryption is easily broken by modern methods I also implemented a more modern encryption system which is the Advanced Encryption Standard (AES) which was used by the NSA in the past.

The users can easily select which one to use and both of them are very simple to use which I demonstrated in the demo video.

Since Java has built in libraries to use modern encryption systems it was not so difficult to do. It would be much harder if we were to write the algorithm in pure code but thankfully most languages and frameworks provide developers with some form of security package these days.
Which should be the standard because computer and application security is a very big problem in modern development and should be taken seriously.
These days we hear about a big security breach nearly every week on major companies which shows how difficult it is to have a secure system and we should place more importance on those who do these kinds of work.

Computer security is very difficult because you need to know every single tool and language used in the application you are securing on top of the knowledge you need to secure it.
Which requires a very big skillset in of itself.

Building Enigma was more difficult for me because I had to write the algorithm by hand. It was very interesting to see the result which was impossible to crack by human trial and error back in WW2.

Thanks for reading all this way and hope you have a great day!
