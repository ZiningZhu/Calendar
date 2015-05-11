# Introduction
The Calendar app is designed to help users keep track of their time.

# Functional Design
There are three main Activities:
(1)MonthView
	It demonstrates an array of days in the current month. The current day is marked with a special background color.
	When clicking on a day, the user is guided to the DayView of that day.
	There is a selection bar on top of this Activity, ( Day | Month )
(2)DayView
	It demonstrates the events that already exists in the day (The information is grabbed from the internal storage).
	At bottom of the events there is a newEvent button, guiding the user to the newEvent Activity.
	There is a selection bar on top of this Activity, ( Day | Month )
(3)NewEvent
	Users select the start / finish time, and the type of the event.
	Upon click of the "save", the information of this event is written into the device's internal storage using FileWriter.
	
# Current Situation that needs to be worked on:
(1)The Graphical User Interface looks not compatible. On the top of MonthView and DayView there are two buttons indicating 
	“day” and “month”, which leads to DayView and MonthView. Their styles are not the same.
(2)In MonthView, the days shall be put into table columns and rows. Also, their styles should be enhanced.
(3)In NewEventActivity, the functions are not debugged yet. I’ll rewrite this part later.
(4)To be added

	
# Copyright
This project is started by Zining, CJ Trolla, and Yasmataz at Hack Western 2015.
Now it is editted by Imran Asghar and Zining Zhu.