[![Published on Vaadin  Directory](https://img.shields.io/badge/Vaadin%20Directory-published-00b4f0.svg)](https://vaadin.com/directory/component/localtime-add-on)
[![Stars on vaadin.com/directory](https://img.shields.io/vaadin-directory/star/localtime-add-on.svg)](https://vaadin.com/directory/component/localtime-add-on)

Contacts - Vaadin Project with External Backend
=

This is a demo Vaadin 8 project with CDI. It relies on an [external backend](https://github.com/amahdy/person-service) to serve the data.

*[Workflow](#workflow) and [FAQ](#faq) are listed below*

You are on the 'Vaadin 8' (latest) branch!
-

There is an older [Vaadin 7 demo](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/tree/vaadin7) branch,
and there is also [Vaadin 7 to Vaadin 8 demo](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/tree/vaadin7-to-vaadin8) branch.

Vaadin 8 Demo
=

The coding process of the demo is available on this 12 minutes video
-

[![Vaadin Demo Coding in a Youtube Video](http://img.youtube.com/vi/Lwhg3NrOLVA/0.jpg)](https://www.youtube.com/watch?v=Lwhg3NrOLVA)

Steps are clearly divided into separate commits
-

[Step 0 | 01:00 | Create a new maven-based Vaadin project using IntelliJ](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/f767c14e6a88262eee2403c5ee1ff78c7ecb5d8b)

[Step 1 | 01:57 | Add the backend person-service and the add-on vaadin-cdi as dependencies](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/86f4376c79bb15d63b7fc8931c586144aa67166b)

[Step 2 | 02:34 | Replace servlet annotations with CDIUI annotation](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/f6e91424438dd03dd9c89b1dd56f71e7683f10d3)

[Step 3 | 03:22 | Place HorizontalSplitPanel and Grid instead of demo code](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/c680896296910c70be087bb06bec88c2cc10241c)

[Step 4 | 04:27 | Populate backend data into the grid](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/6a40fe37d03dedf34eb0ea5ad001f35f56e7cd40)

[Step 5 | 05:08 | Create a new design file using Vaadin Designer](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/df19c716d0ca6e5a311e2f04fcd8b903c8643f2f)

[Step 6 | 05:26 | Create the form using Vaadin Designer](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/b1a0537f1ff311db54e26874d5fb6abebd3b998c)

[Step 7 | 07:45 | Use the design inside Java code](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/4306a341b597c709c97f41939dea614031cfac80)

[Step 8 | 08:25 | Add selection listener to the grid](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/15432ac3b47514055974d7f58e4416a1d0beb37d)

[Step 9 | 09:00 | Define data binder for the form](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/d497b2680d9aef835a6c3c54d7dcae5769ff7d31)

[Step 10 | 10:01 | Save changes to the local object in the binder](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/e658130c014ca04ab49f980fdf39e81718fb7a41)

Other enhancements to the code that are not mentioned in the video
-

[Extra 1 | Add Valo style to the control buttons](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/fdfc29ae65f443b257012ced4ad681426f0afd6a)

[Extra 2 | Add icon to the save button](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/0abe754541f2abfccd3365bb447b4423f7b6e547)

[Extra 3 | Add image component in the form](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/15c70cfbcdd9b54031f22c6e6c7a3a9bcca8405c)

[Extra 4 | Bind picture resource to image component](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/f9308f428f7db5c60ca3556145126b89adb70a6b)

[Extra 5 | Handle default and null selection in grid](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/27a5318a15cd62def369bd70075bb33c36277fd4)

[Extra 6 | Organize and remove unneeded grid columns](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/5aa3539ffb801fb76ae97d97fce1055bbb192bac)

[Extra 7 | Add cancel event](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/f3d83044bd7ad69aed9d6d21d822eb87b494cdd5)

[Extra 8 | Add delete event](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/073cf84d95ce34d9d9a7a13328ecaf05b25ad2ed)

[Extra 9 | Host widgetset in CDN and upgrade framework version](https://github.com/amahdy/vaadin-stepbystep-demo-contacts/commit/54e49bb711830128ad717f1beef6df3a3cbd44f9)

FAQ
-

1. **Where can I find the person-service?**
The backend service is located in [this repository](https://github.com/amahdy/person-service/tree/1.2) along with detailed steps on how to install it.
You can also get it from [Vaadin Directory](https://vaadin.com/directory#!addon/demo-person-service) (version 2.x only).

1. **Where can I find the backend project?**
Please refer to previous answer.

1. **The person-service does not work?**
For this demo with  Vaadin 8, you must use version 2.x.

1. **I'm using Wildfly 10 as shown in the video, but I get 404 in the browser?** Sometimes Wildfly deploys with version suffix, and the context root must contain this suffix. You can change it from configurations, and in this simple demo you can just append `-1.0-SNAPSHOT` to the context root. So the demo should be available under this URL: `http://localhost:8080/contacts-1.0-SNAPSHOT/`

1. **I'm using Tomcat/Jetty/..etc and it does not work?** In this particular example I had to use Wildfly, because of CDI and JEE specs, the application server must fully support those specs. Otherwise in other Vaadin application, any servelet container such as tomcat and jetty will work just fine.

1. **I'm following the demo step by step, but when I refresh the browser, modifications do not appear?** Sometimes you need to restart the server to be able to see modifications. In the video I was using some external tools for automatic redeployment.

1. **Is it limited to IntelliJ?**
You can use [Eclipse](https://www.youtube.com/embed/k47CkTx9hUw?start=39&end=94&version=3), it has [Vaadin Designer plugin](https://vaadin.com/designer/get-started#eclipse) as well. [Netbeans plugin](http://plugins.netbeans.org/plugin/50531/vaadin-plug-in-for-netbeans) is available but currently it has limited functionalities.
You can also easily get started from commandline using [Maven archetype](https://vaadin.com/maven).

1. **How to install Vaadin Plugin for Eclipse?**
Please follow [this video tutorial](https://youtu.be/o93ofXBIkf8?t=36s) for installing the plugin on Eclipse.

1. **Where to find the Vaadin CDI Add-on?**
It's available in [Vaadin Directory](https://vaadin.com/directory#!addon/vaadin-cdi).

Workflow
-

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
