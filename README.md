Contacts - Vaadin Project with External Backend
====================================================

This is a demo Vaadin 7 project with CDI. It relies on an [external backend](https://github.com/amahdy/person-service) to serve the data.

The coding process of this demo is available on this 12 minutes [Youtube video](https://www.youtube.com/watch?v=k47CkTx9hUw). And the steps are clearly divided into separate commits:

[Step 0 | 00:55 | Create a new Vaadin project using Eclipse plugin](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/3ae97bf99f8c18b22a76db2f1da293c18e19ac9c)

[Step 1 | 02:30 | Place HorizontalSplitPanel and Grid instead of demo code](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/c6da6eb59bc35ecdb2195bc4689abcaeffeee852)

[Step 2 | 03:13 | Add person-service maven dependencies](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/6f67a2852758e874c8a7a9cf9fbd8f310e75b8ed)

[Step 3 | 03:49 | Add Vaadin CDI Add-on maven dependency](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/db0146a04503c25b7d873e8de705de30feb27ce0)

[Step 4 | 04:04 | Replace servlet annotations with CDIUI annotation](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/5fdcf5b4e3de11f4a5ad7d9152ce8e75149cfd7f)

[Step 5 | 04:55 | Populate backend data into the grid](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/75af6dcf2db98f2350c946e77416735198932800)

[Step 6 | 05:31 | Create a new design file using Vaadin Designer](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/8012fe9801d447cd3503e6b732ccfed25ae67e7d)

[Step 7 | 07:25 | Create the form using Vaadin Designer](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/e0873a07598103580834ab9714a1be6c5197aefc)

[Step 8 | 08:14 | Use the design inside Java code](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/5ba81e090a7d8f82edd77f25ffdf04f4156c26e5)

[Step 9 | 09:05 | Add selection listener to the grid](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/35892f39c69ba00749a6cdd9cbf78e0b4691da87)

[Step 10 | 09:39 | Define data binder for the form](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/0ba8bfe4f02c4425a41c48107f92a2e35e9e9368)

[Step 11 | 10:15 | Save changes to the local object in the binder](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/29e8bac0c32447a1caa5922cb701ea552557a6c5)

[Step 12 | End of Video | Update backend as well](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/39b0250b24abb467636e7c93435d782b954b7bd6)

And some other extra enhancements to the code that are not mentioned in the video:

[Extra 1 | Use the new and faster API refreshRows for Grid](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/282a177c2bcd79c02487b0879ec1af1406249b9e)

[Extra 2 | Add Valo style to the control buttons](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/913571a1befa62c7283e3eaafbab4bd90f93a19e)

[Extra 3 | Add image component in the form](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/52e7355248dce95e7c9e93e041c4e65744654d53)

[Extra 4 | Bind picture resource to image component](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/287a22e137942e852824a798afc1a50142da6451)

[Extra 5 | Handle default and null selection in grid](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/9b3db539e6ecd8107dab3d49256eb50deedb8dfe)

[Extra 6 | Use better communication event](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/933606d7164a45444ebb0c9668de69eac9cd4fcb)

[Extra 7 | Organize and remove unneeded grid columns](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/cb601ba889fcab3215e3e66085b1708efb02c751)

[Extra 8 | Add cancel event](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/4cdde119ffee0edbe1108b1084e343be091bebdf)

[Extra 9 | Add delete event](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/5afe89934b1043d19b06ec036df975b64ed670e2)

[Extra 10 | Host widgetset in CDN](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/4bb4f359056252184a3051c6c359a35f17dfe272)

Workflow
========

Clone this project from GitHub and check out vaadin7 branch:

    git clone https://github.com/amahdy/vaadin-stepbystep-demo-contacts.git
    cd vaadin-stepbystep-demo-contacts/
    git checkout vaadin7

To compile the entire project, run:

    mvn install

To run the application, run:

    mvn wildfly:run
    open http://localhost:8080/contacts-1.0-SNAPSHOT/

To produce a deployable production mode WAR:
- change productionMode to true in the servlet class configuration (nested in the UI class)
- run "mvn clean package"
- test the war file with "mvn jetty:run-war"

Client-Side compilation
-------------------------

The generated maven project is using an automatically generated widgetset by default.
When you add a dependency that needs client-side compilation, the maven plugin will
automatically generate it for you. Your own client-side customisations can be added into
package "client".

Debugging client side code
  - run "mvn vaadin:run-codeserver" on a separate console while the application is running
  - activate Super Dev Mode in the debug window of the application

Developing a theme using the runtime compiler
-------------------------

When developing the theme, Vaadin can be configured to compile the SASS based
theme at runtime in the server. This way you can just modify the scss files in
your IDE and reload the browser to see changes.

To use the runtime compilation, open pom.xml and comment out the compile-theme
goal from vaadin-maven-plugin configuration. To remove a possibly existing
pre-compiled theme, run "mvn clean package" once.

When using the runtime compiler, running the application in the "run" mode
(rather than in "debug" mode) can speed up consecutive theme compilations
significantly.

It is highly recommended to disable runtime compilation for production WAR files.

Using Vaadin pre-releases
-------------------------

If Vaadin pre-releases are not enabled by default, use the Maven parameter
"-P vaadin-prerelease" or change the activation default value of the profile in pom.xml .
