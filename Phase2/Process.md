# Team 2's Scrum-Like Process

### Conducted Meetings

#### January 29 (BA 3012)

Highlights of this meeting:

- What we decided on for each aspect of the MVP.
- A to-do list of who is doing what for Phase 1.
- **Github Issues**
  - Issue list for [Sprint 1](https://github.com/UoT-CSC30x-W15/301W15-Prj-Team2-repo/issues?q=milestone%3A%22P2-Sprint+1%22)
- **Retrospective**
  - It was a productive meeting, we didn't plan any actual implementation.
  - Splitting the work early was useful, it gave everyone a specific portion to work on.


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
- **Github Issues**
  - Issue list for [Sprint 2](https://github.com/UoT-CSC30x-W15/301W15-Prj-Team2-repo/issues?q=milestone%3A%22P2-Sprint+2%22)
- **Retrospective**
  - We did not achieve all the tasks we allocated this week.
  - In hindsight, we spent a lot of time discussing and dividing tasks than actually decide how implementation would work
  - This caused the backlog and confusion about specific implementation later in the phase.


#### February 23, 2015 (BA 2270)

- Discussed our progress with the TA
- Updated the team on our progress
- Discussed specific implementation details
- **Github Issues**
  - Issue list for [Sprint 3](https://github.com/UoT-CSC30x-W15/301W15-Prj-Team2-repo/issues?q=milestone%3A%22P2-Sprint+3%22)
- **Retrospective**
  - This was a productive week. We got thought almost everything layed out in out plan.

Decisions:

- We will try to generalize the way we draw "nodes" and "edges" in the play fragment of the application.
	- This allows us to reuse code to easily add interactivity to every data structure using nodes and edges.  

#### March 2, 2015 (BA 3008)

Highlights of this meeting:

- Discussed how to handle the application post PR #33.
- Discussed implementation of issue #16.
- Discussed the outline for summaries and implementation details in terms of using a fragment.
- **Github Issues**
  - Issue list for [Sprint 4](https://github.com/UoT-CSC30x-W15/301W15-Prj-Team2-repo/issues?q=milestone%3A%22P2-Sprint+4%22)
- **Retrospective**
  - This week was more about fixing minor bugs and getting out project ready for demo
  - It involved all the written part required for submission
  - We finished all the work we set out to achieve.

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
