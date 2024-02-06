import 'package:flutter/material.dart';
import 'package:myflutter/screen.dart';

void main() {
  runApp(MyApp());
} // end main

class MyApp extends StatelessWidget {
  // above 'build' we deal with data (processes)
  // 'build' do the interface (what the user see)

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData.dark(),
      title: "Guess",
      home: Guess(),
    );
  }
} // end class my app

///////////// any page (log in..search..ect) should have it's own class \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
