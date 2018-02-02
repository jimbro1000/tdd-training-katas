# Ten Pin Bowling Score Card Part Two

## Grade - Intermediate

## Introduction
An extension to a simpler kata, this kata adds requirements to a finished
product but requires that the earlier kata is completed.

## Requirements
  * Extend the "Game" class with a new method
  * scoreCard() can be called after each roll to return the score breakdown per
  frame, where a score is undetermined a blank is shown. The score format is a
  string containing a JSON structure.
  * The schema for the scorecard is
  
  ```json
  {  
    "title": "BowlingScoreCard",  
    "type": "object",  
    "properties": {  
      "totalScore": {  
        "description": "total score of frames on the card",  
        "type": "integer",  
        "minimum": 0,  
        "maximum": 300  
      },  
      "frames": {  
        "type": "array",  
        "maxItems": 10,  
        "items": {  
          "type": "object",  
          "properties": {  
            "frame": {  
              "type": "integer",  
              "minimum": 0,  
              "maximum": 10  
            },  
            "rolls": {  
              "type": "array",  
              "maxItems": 3,  
              "items": {  
                "type": "object",  
                "properties": {  
                  "roll": {  
                    "type": "integer",  
                    "minimum": 1,  
                    "maximum": 3  
                  },  
                  "rollScore": {  
                    "type": "integer",  
                    "minimum": 0,  
                    "maximum": 10  
                  },  
                  "bonus": {  
                    "type": "string",  
                    "enum": [  
                      "none",  
                      "split",  
                      "spare"  
                    ]  
                  }  
                }  
              },  
              "required": ["roll", "rollScore", "bonus"]  
            },  
            "frameScore": {  
              "type": "integer",  
              "minimum": 0,  
              "maximum": 30  
            }  
          }  
        },  
        "required": ["frame", "rolls"]  
      }  
    },  
    "required": ["totalScore", "frames"]  
  }  
  ```
