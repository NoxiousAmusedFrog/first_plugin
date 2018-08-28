import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:first_plugin/first_plugin.dart';

void main() => runApp(new MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => new _MyAppState();
}


class _MyAppState extends State<MyApp> {
//  String act = "0";
//  int simId = 0;

  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      home: new Scaffold(
        appBar: new AppBar(
          title: const Text('Call TruePhone activities example app'),
        ),
        body:
        new Column(
            children:
            <Widget>[

              new RaisedButton.icon(
                  icon: const Icon(Icons.contact_phone),
                  label: const Text('Launch Contacts'),
                  onPressed:() {FirstPlugin().launchTruePhone(1);}),

              new RaisedButton.icon(
                  icon: const Icon(Icons.history),
                  label: const Text('Launch Recent'),
                  onPressed: () {FirstPlugin().launchTruePhone(0);}),

              new RaisedButton.icon(
                  icon: const Icon(Icons.star_border),
                  label: const Text('Launch Favorites'),
                  onPressed: () {FirstPlugin().launchTruePhone(2);}),

            ]
        ),
      ),

    );
  }
}
