# Ten Pin Bowling Score Card Part Two

## Grade - Intermediate

## Introduction
An extension to a simpler kata, this kata adds requirements to a finished
product but requires that the earlier kata is completed.

If necessary a worked solution for the earlier kata is available from the
branch "tenPinBowlingPart1".

## Requirements
  * Extend the "Game" class with a new method
  * scoreCard() can be called after each roll to return the score breakdown per
  frame
  * where a frame score is undetermined a zero is shown for the frame score
  * the total score is the known cumulative score of the frames
  * the score format is a string containing a JSON structure
  * the swagger (openAPI) schema for the scorecard JSON is
  
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
              "minimum": 1,  
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
                      "strike",  
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

## Examples

Given a set of rolls:

| Roll | Pins | Frame |    Cum. Score    |
| ---- | ---- | ----- | ---------------- |
|  1   |  7   |   1   |   7              |
|  2   |  2   |   1   |   9              |
|  3   |  8   |   2   |  17              |
|  4   |  2   |   2   |  29              |
|  5   | 10   |   3   |  49              |
|  6   |  9   |   4   |  58              |
|  7   |  1   |   4   |  59+r(8)         |

the expected output JSON is:

```json
{
  "totalScore": 49,
  "frames" : [
    {
      "frame" : 1,
      "rolls" : [
        {
          "roll" : 1,
          "rollScore" : 7,
          "bonus" : "none"
        },
        {
          "roll" : 2,
          "rollScore" : 2,
          "bonus" : "none"
        }
      ],
      "frameScore" : 9
    },
    {
      "frame" : 2,
      "rolls" : [
        {
          "roll" : 1,
          "rollScore" : 8,
          "bonus" : "none"
        },
        {
          "roll" : 2,
          "rollScore" : 2,
          "bonus" : "spare"
        }
      ],
      "frameScore" : 20
    },
    {
      "frame" : 3,
      "rolls" : [
        {
          "roll" : 1,
          "rollScore" : 10,
          "bonus" : "strike"
        }
      ],
      "frameScore" : 20
    },
    {
      "frame" : 3,
      "rolls" : [
        {
          "roll" : 1,
          "rollScore" : 9,
          "bonus" : "none"
        },
        {
          "roll" : 2,
          "rollScore" : 1,
          "bonus" : "spare"
        }
      ],
      "frameScore" : 0
    }  
  ]
}
```