# Phase 1 - Planning #

## Introducing The Team ##

[Group photo]

### Vaishali Deswal ###
Vaishali is a 4th year CS and Bioinformatics student at University of Toronto. She is a python enthusiast and completing her fourth year project to create a tool to visualize RNA data of the plant, Arabidopsis Thaliana. She has recently gotten addicted to Quora.

### Ajit Pawar ###
Ajit is a fourth year Computer Science specialist at University of Toronto. He loves to attend hackathons and is always excited at the opportunity of using new hardware. He completed his PEY at BlackBerry (Waterloo) and is looking forward to apply his skills to this project. In his spare time, he loves to hit the gym, watch F1 and browse through some awesome sub-reddits to expand his mind. And of course he struggles with musical instruments :(

### Shahin Yousefi ###
Shahin is a third-year Computer Science specialist student at University of Toronto. His hobbies are Android programming and finding memes for any situation. He listens to way too much mainstream music and loves to stay up-to-date on tech news through social media. Despite being an introvert, he lives dangerously by using beta, alpha, or even pre-alpha software if it means he will get new features.

### Name ###
bio

### Name ###
bio

### Name ###
bio

### Name ###
bio

### Name ###
bio

## Choosing The Project ##
Data structures are fundamental building blocks of Computer Science. In today's world, the need to conquer the inherent complexity of these concepts is critical for success. But, learning data structures can be intimidating for some. The abstractness of the concept can be hard to grasp and students can get stuck trying to "imagine" how it works. Existing teaching methods like videos (Khan Academy) and  text-based forums (StackOverflow) don't quite solve the problem. And this is why we chose to build Structra. We chose this problem space because we recognized there was not a single platform that helps students learn about data structures in an interactive manner. Our product will an insightful, organized and immersive way of learning about Trees, Lists, Hash Tables and Objects. Technical content will come from verified sources like textbooks and Wikipedia. Users will have an opportunity to choose from variety of topics with varying difficulty levels. As an added feature, we thought of implementing exercises and quizzes to give the user an opportunity to validate their learning. We will be making use of open source API and bootstraps to help us with the interactivity of the UI.

In essence, we wish to build a product that helps students learn by visualizing the abstract concepts in Computer Science


## Personas ##

### Savio ###
Savio is a 17 years old high school student in his senior year. He lives in North York, Toronto. He likes to play guitar on the side and was part of a garage band with his friends until last year. His parents are high school teachers. However, it is his uncle that Savio wants to follow in terms of career. His uncle is a Software Developer at TD bank and he got Savio interested in taking up the discipline. Thus, Savio tried a CS course in school and liked it very much. He has been accepted to University of Toronto Computer Science program and is very excited to start.

### Cynthia ###
Cynthia is a 1st year Computer Science student at the University of Toronto. She is 18 years old and currently single. She is taking the introductory courses of the Computer Science program. She started learning programming in high school and is excited to pursue it further. Since she is usually on campus till late,she is looking to get involved in extra curricular activities to complement her studies. She has a particular interest in Habitat for Humanity and the archery club at UofT. She has a long commute from Mississauga to the St. George campus and likes to read (books/lecture material) on her commute to campus.

### Seamus ###
Seamus is a student in his final year stuyding Computer Science at University of Toronto. He is 22 years old and lives in Vaughan, Ontario. He works part-time as a freelance web developer, while also working on MarkUs (CS department's grading software) as his final year project. He is an avid gamer with Halo and FIFA 2015 being his favourites. He also loves to network with new people and goes to a lot of Meet-ups around the city. He, like most of his graduating friends, is looking for full-time employment. He recently has scored interviews from IBM, Amazon and RBC Bank.



## User Stories ##

### Legend: ###

#### Priority: ####
1. We must have this feature, without it our product has no value to our users.
2. Valuable feature, but we can still release a product without it.
3. Might be valuable, but we should look at it later.

#### Difficulty: ####
1. Easiest
2. Medium
3. Hard

Each tuple is of the form (Priority, Difficulty)

* **(2,1)** UserX wants to search a list of topics to learn because he is particularly interested in learning about Linked list for his midterm.
* **(2,3)** UserX wants an interactive user interface that helps him create a visual data structure because he finds it difficult to understand by reading the textbook.
* **(2,3)** UserX wants to create a tree by tapping on a node which then gets added to the tree 
* **(2,3)** UserX wants to re-balance the tree because he wants to avoid making the tree one-side-heavy
* **(3,1)** UserX wants to login to the app so the app knows the user and what they were learning
* **(1,2)** UserX wants to save the state of the app because he wants resume where he left off
* **(3,2)** UserX wants to be able to test her knowledge by doing simple online quizzes to better prepare for her tests
* **(1,1)** UserX wants to read summaries for topics in preparation for his upcoming exam
* **(2,3)** UserX wants to interact with structures through drag-and-drop because they find visual learning a more helpful tool
* **(2,3)** UserX wants to insert a node into a data structure in order to build a tree because he is trying to learn the insert operation for trees.
* **(2,3)** UserX wants to delete a node in order to extract the maximum value
* **(2,1)** UserX logs in to Structura to learn about binary search trees because her friend recommended this app for learning data structures
* **(3,2)** UserX takes a quiz using Structura to test how well UserX knows about binary search trees   

##### Additional features:

* (3,3) UserX wants to play interactive games to learn data structures in a fun way
* (3,1) User profile?

*TODO: User stories have to be in the form of userx does x because y. All one liners or so*
*TODO: bold each tuple*

### For PR User Stories ###

#### Piotr Recalls an Epiphany (State Saving) ####
Piotr had an epiphany of singly linked lists one night and decided to carry out his suspicions on the Structra app. The interactivity of SLLs confirmed his theory, thus Piotr closed Structra and slept peacefully the night before his midterm. In the morning, Piotr recalls his epiphany and decides to review what he did on Structra. Once he launches the app, it brings him straight to where he left it off with all his interactions rendered. Satisfied with what he reviews, Piotr confidently faces his midterm. 
 
#### Piotr Tames the List (Searching) ####
Structra contains many topics to view. Piotr can navigate the different topics by searching using keywords. So, flipping between reading about singly linked lists to binary heaps is very easy for Piotr since all he does is open the overflow menu and entry his query at the top of said menu. 

### Excluded Features/User Stories

*TODO*


## MVP ##
Structura is a tool that allows people to learn data structures efficiently. The app consists of a list of various data structures to start from. They will be ordered in a particular manner so as to maximize learning, and guide beginners through the process. However, if you are not a beginner, the app has a feature that allows you to search for specific topics to learn. You can look up any of the available data structures and study them specifically, instead of going through the guided sections. Another cool feature in the app is being able to save your state. If you are in a hurry, or wish to look at your progress at a later time, Structura’s “Snapshot” feature will be handy. An app cannot appeal to the masses or please the current group of customers if it is not easy to use. Users will be mostly students, ranging from those in their first year, who can use this app to get a head start, or second year, who can review and practice lecture topics here, or even higher year students who can brush up their skills on these topics before job interviews, or prepare themselves for other courses. That is why Structura has a great, fluid UI, which would not only guide users through the app, but also provide a unique learning experience through interactivity in visualizing data structure operations, which is not possible to have in the classroom. It allows you to play with the individual elements of the data structure. And if one has already gone through the learning process using Structura, and wants a quick review before their exams, or an interview, Structura provides the “Summary” feature, which will consist of a brief description of the data structure, its operations, applications, and some of the abstract data types it supports. Thus, Structura is “the complete learning tool” for these concepts. 

Making this app will not be easy. There are obvious hurdles in this process. Some of them will be the difference in knowledge base of the group. But that is where we will turn it into our advantage. People from different backgrounds have different skills, and hence we will divide the tasks according to everyone’s strengths. Apart from that, co-ordination and schedule conflicts will be a problem, but then we have Git, and Slack to keep us organized.

## Release & Iteration Planning ##
*TODO*

## CRC Cards ##

*TODO*

###### Class Name
| Responsibility        | Collaboration           | 
| ------------- |:-------------:| 
| A  | A |
| A  | A |


## CRC Play out

*TODO*

## UI Mockups ##

**Drawer to select a Data Scruture**

![Drawer](Mockups/DS-Drawer.png)

**An interactive canvas to play around with different data scructure operations**

![Play](Mockups/LL-Play.png)

**A summary for the Data Scruture**

![Summary](Mockups/LL-Summary.png)

**Test your knowledge**

![Quiz](Mockups/LL-Quiz.png)
