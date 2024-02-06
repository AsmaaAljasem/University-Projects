import 'dart:math';

import 'package:flutter/material.dart';
import 'package:myflutter/values.dart';

class Guess extends StatefulWidget {
  const Guess({super.key});

  @override
  State<Guess> createState() => _GuessState();
}

class _GuessState extends State<Guess> {
 
  var randomImage = MyElement.myImages.values
      .elementAt(Random().nextInt(MyElement.myImages.length));
  List keysHere = MyElement.myImages.keys.toList();
 
  // check
  String answer = "";

  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        backgroundColor: Color(0x03001C),
        body: Column(
          children: [
            Container(
              margin: EdgeInsets.only(top: 80, left: 20, right: 20, bottom: 10),
              child: Text(
                "IN WHICH INDUSTRY IS THIS ITEM USED?",
                style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
              ),
            ),
            theImage(),
            // Text
            Wrap(
              children: keysHere
                  .map(
                    (aKey) => SizedBox(
                      width: 180,
                      height: 50,
                      child: myTextButons(aKey),
                    ),
                  )
                  .toList(),
            ),
            Container(
              margin: EdgeInsets.only(top: 20),
              child: Row(children: [
                Container(
                  margin: EdgeInsets.only(left: 15),
                  alignment: Alignment.topLeft,
                  child: Text(
                    "YOUR ANSWER IS:",
                    style: TextStyle(fontSize: 25, fontWeight: FontWeight.bold),
                  ),
                ),
                Container(
                  margin: EdgeInsets.only(left: 100, bottom: 10),
                  child: ElevatedButton.icon(
                    icon: const Icon(Icons.refresh),
                    label: const Text(" "),
                    onPressed: () {
                      setState(() {
                        randomImage = MyElement.myImages.values.elementAt(
                            Random().nextInt(MyElement.myImages.length));
                        answer = "";
                        theImage();
                      });
                    },
                    style: ElevatedButton.styleFrom(
                        backgroundColor: Color.fromARGB(255, 19, 43, 84)),
                  ),
                )
              ]),
            ),
            Container(
                width: 300,
                height: 100,
                margin: EdgeInsets.only(top: 20),
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(10),
                  color: const Color.fromARGB(255, 29, 29, 29),
                  border: Border.all(color: Colors.white),
                ),
                alignment: Alignment.center,
                child: displayAnswer(answer)),
          ],
        ),
      ),
    );
  }

// design the buttons
  Widget myTextButons(value) {
    return Padding(
      padding: const EdgeInsets.all(2),
      child: Material(
        color: Color.fromARGB(255, 19, 43, 84),
        clipBehavior: Clip.hardEdge,
        elevation: 6,
        shape: OutlineInputBorder(
            borderSide: const BorderSide(color: Colors.white10),
            borderRadius: BorderRadius.horizontal(
                left: Radius.circular(6), right: Radius.circular(6))),
        child: InkWell(
          onTap: () => butonIsPressed(value),
          child: Center(
            child: Text(
              value,
              style: TextStyle(
                  fontSize: 25,
                  fontWeight: FontWeight.bold,
                  color: Colors.white),
            ),
          ),
        ),
        //function
      ),
    );
  }

  butonIsPressed(String userChoice) {
    if (userChoice ==
        keysHere.firstWhere((r) => MyElement.myImages[r] == randomImage)) {
      //userIsRight();
      answer = "true";
    } else {
      answer = "false";
      //userIsWrong();
    }
    setState(() {});
  }

  Widget displayAnswer(String str) {
    switch (str) {
      case "":
        return Text("");

      case "true":
        return Text(
          "Correct",
          style: TextStyle(
            fontSize: 30,
            color: Color.fromARGB(171, 0, 175, 6),
            fontWeight: FontWeight.bold,
          ),
        );

      case "false":
        return Text(
          "False",
          style: TextStyle(
              fontSize: 30,
              color: const Color.fromARGB(255, 186, 15, 3),
              fontWeight: FontWeight.bold),
        );
    }
    return Text("");
  }

  Widget theImage() {
    return Container(
      margin: EdgeInsets.only(bottom: 10),
      child: ClipRRect(
        borderRadius: BorderRadius.circular(8.0),
        child: Image(
          image: randomImage,
          height: 240,
          width: 300,
          fit: BoxFit.fill,
        ),
      ),
    );
  }
} // end of class
