### Android Components in our app
There are 4 major components to our Android app: Activities, Views, Model, Database
###### Activities
An Activity in Android represents a screen that the user can interact with. An activity interacts with the user to do one and only one thing. Since our app covers two types of data structures (Linked List and BST), we created main two activities; one for each data structure.

###### Views
In Andriod, Views are UI components that could be used to build user interface. For Linked Lists, we have the Node View which displays a typical [Node](img/node.png).

###### Model
We have 3 models to represent the following:

| Model   | Explanation |
| ------------- | ------------- |
| LLNode  | An int value and a next pointer, representing a node in linked list  |
| BSTNode | An int value and two pointers (left tree, right tree), representing a node in a Binary tree.  |
| Question/Answer | A string representing a typical question/answer in a Quiz|

###### Database/Storage
The only need for storage in our app was to store the list of questions and answers for the "Quiz" section. We chose to use an XML file to take advantage of Android's inherent use of XML to render views and layouts. This eliminated the need for a 3rd party storage solution.

---

### Architecture decisions
##### Decision 1: Choosing to do a mobile app
Reasons: A major architecture decision we made was to make our application a mobile app. We did this because we felt that the Android environment gave us the flexibility needed to create an app with multiple screens and data structures. Also, the syntax for UI styling is very familiar to our team. Morever, Android was chosen over iOS or Windows to make our app available to a larger market.

Good decision?: Yes, we believe this was a very good decision since this level of immersive interactivity could not have been achieved with a web app


##### Decision 2: Using singleton design pattern for overview styler.
Reasons: We made this decsion because we needed to apply color to the title bar of the app in the overview screen.

Good decision?: Yes, by doing this we eliminate the need to decode our structra app icon every time the activity changes.


##### Decision 3: Used template method for the base activity.
Reasons: We used this design pattern on the base activity because it is an abstract activity that handles common functionality like the navigation drawer.

Good decision?: Yes, this reduces the code burden on the developer making changes to the base activity and allows us to make some neat additions to our app such as navigation drawer.
