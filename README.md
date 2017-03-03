Contacts - Vaadin Project with External Backend
====================================================

This is a demo Vaadin 7 project with CDI. It relies on an [external backend](https://github.com/amahdy/person-service/tree/1.2) to serve the data.

*[Workflow](#workflow) and [FAQ](#faq) are listed below*

##You are on the 'Vaadin 7' branch!

To see the latest demo, go to [the main project page](https://github.com/amahdy/vaadin-stepbystep-demo-contacts).

##The coding process of the demo is available on this 12 minutes video

[![Vaadin Demo Coding in a Youtube Video](http://img.youtube.com/vi/k47CkTx9hUw/0.jpg)](http://www.youtube.com/watch?v=k47CkTx9hUw)

##Steps are clearly divided into separate commits

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

##Other enhancements to the code that are not mentioned in the video

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

##FAQ

1. **Where can I find the person-service?**
The backend service is required to be installed locally to be able to run this project. It's located in [this repository](https://github.com/amahdy/person-service/tree/1.2) along with detailed steps on how to install it.
You can also get it from [Vaadin Directory](https://vaadin.com/directory#!addon/demo-person-service) (version 1.x only).

1. **Where can I find the backend project?**
Please refer to previous answer.

1. **The person-service does not work?**
For this demo with  Vaadin 7, you must use version 1.x.

1. **I'm using Wildfly 10 as shown in the video, but I get 404 in the browser?** Sometimes Wildfly deploys with version suffix, and the context root must contain this suffix. You can change it from configurations, and in this simple demo you can just append `-1.0-SNAPSHOT` to the context root. So the demo should be available under this URL: `http://localhost:8080/contacts-1.0-SNAPSHOT/`

1. **I'm using Tomcat/Jetty/..etc and it does not work?** In this particular example I had to use Wildfly, because of CDI and JEE specs, the application server must fully support those specs. Otherwise in other Vaadin application, any servelet container such as tomcat and jetty will work just fine.

1. **I'm following the demo step by step, but when I refresh the browser, modifications do not appear?** Sometimes you need to restart the server to be able to see modifications. In the video I was using some external tools for automatic redeployment.

1. **Is it limited to Eclipse?**
You can use [IntelliJ](https://www.youtube.com/watch?v=la7WlG9rQvw), it has [Vaadin Designer plugin](https://vaadin.com/designer/get-started#intellij) as well. [Netbeans plugin](http://plugins.netbeans.org/plugin/50531/vaadin-plug-in-for-netbeans) is available but currently it has limited functionalities.
You can also easily get started from commandline using [Maven archetype](https://vaadin.com/maven).

1. **How to install Vaadin Plugin for Eclipse?**
Please follow [this video tutorial](https://youtu.be/o93ofXBIkf8?t=36s) for installing the plugin on Eclipse.

1. **Where to find the Vaadin CDI Add-on?**
It's available in [Vaadin Directory](https://vaadin.com/directory#!addon/vaadin-cdi).

##Workflow

**Clone this project from GitHub**

    git clone https://github.com/amahdy/vaadin-stepbystep-demo-contacts.git
    cd vaadin-stepbystep-demo-contacts/

**To compile the entire project, run**

    mvn install

**To run the application, run**

    mvn wildfly:run

**The application will be available in this URL**

     http://localhost:8080/contacts-1.0-SNAPSHOT/

**Questions or issues?**
Please post them in [the issues tracker](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/issues).
