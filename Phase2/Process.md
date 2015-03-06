# Team 2's Scrum-Like Process

### Conducted Meetings

#### January 29 (BA 3012)

Highlights of this meeting:

- What we decided on for each aspect of the MVP.
- A to-do list of who is doing what for Phase 1.

Decisions:

- The application should look similar to the mocks found at /Phase 1/Mockups
	- The mocks represent every feature we have promised for the MVP in an Android style compliant manner.
- We will not implement an account system as part of the MVP
	- To do this properly and impressively, we would require an online service to authenticate against. This resource was not provided by the course and the expertise for it was non-existent.

#### Feb 16, 2015 (BA 2270)

Highlights of this meeting:

- Getting all team members up to speed in terms of tool set setup.
- Created a new branch "app" for application development.
- Created Github issues to manage progress (more to come).
- Assigned preliminary issues to group members.

Decisions:

- We will try to generalize the way we draw "nodes" and "edges" in the play fragment of the application.
	- This allows us to reuse code to easily add interactivity to every data structure using nodes and edges.  

#### March 2, 2015 (BA 3008)

Highlights of this meeting:

- Discussed how to handle the application post PR #33.
- Discussed implementation of issue #16.

Decisions:

- We can save the state of the application to JSON files.
	- JSON files are better than plain text files to handle in Android.

### Other Tools

Our team is using [ZenHub](https://www.zenhub.io/) as our agile project management tool. It is similar to Trello boards, but it integrates natively with GitHub's issue management system.


###Major Decisions

One of the first major decisions we made was to make our application a mobile app. We did this because we felt that the Android environment gave us the flexibility needed to create an app with multiple screens and data structures. Also, the syntax for UI styling is very familiar to our team. The second major decision we made was to have our MVP only include the linked-list data structure. We did this because we felt under the time constraints this was mostly likely the best decision for our team. This was the right decision because within the second sprint we were able to get the data structure implemented. The third decision we made was to not have a scrum master. We did this because we felt the process should be more democratic and everyone should have an equal say in the project. This was the right decision because by not appointing a scrum master we had an extra person to work on the app.

### Issue management

We used Github Issues as our issue management system.

#### Naming conventions
When creating a new branch, the convention was to start the branch name starting with the issue number.<br>
For example, if a new branch was being created for work on issue #36, then the branch should be named <b>36-search-feature</b>

#### Labels
Our [issues page](https://github.com/UoT-CSC30x-W15/301W15-Prj-Team2-repo/issues?q=+is%3Aissue+) gives a glimpse of all the various labels we used
* <b>Urgency</b><br>
Labels like <b>Urgent</b> to draw attention to a critical issue that is possibly bottlenecking

* <b>Estimation points</b><br>
Labels to show estimated relative difficulty of this issue

* <b>Feature</b><br>
Some issues are non-critical and can be labeled as <b>feature</b>. This allows us to prioritize issues

#### Milestones
We created a milestone for every sprint. Each milestone was just be the date on which the sprint ends. The advantages of doing this were:

  * It indicates status of "in current" sprint
  * If labels were used instead, they’d clutter the ZenHub board and would need to be removed when we finish the sprint, which adds an extra step.
  * Milestones also indicates which sprint the corresponding story was part of<br>

Milestones can be kept even when we’re done with a story.


#### Team conventions
Our team followed the convention of adding screenshots and links when making a pull request. Take a look at pull request [#25](https://github.com/UoT-CSC30x-W15/301W15-Prj-Team2-repo/pull/25) as an example.
