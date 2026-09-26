# Canvas Announcements Web App 
### by Riordin Dupree

Tool allows the user to view a list of announcements of selected classes through the graph at the bottom of the page in a neatly ordered list. The user can select which classes they would like to see announcements for by clicking the check box next to the items in the list.

# Setup Instructions. 
Step-by-step instructions for cloning the repo, installing dependencies, creating a .env file, and running the tool. Assume the reader has never used your language’s package manager before.

### Pre-Set Up

In order to run this application, you will need Java 17 or later, as well as Maven 3.5+ in order to run Java and SpringBoot.

### 1. Clone the repository

```bash
git clone https://github.com/riordindupree/CanvasWebApp-RiordinDupree.git
cd CanvasWebApp-RiordinDupree
```

### 2. Create your `.env` file

Copy the template and open it in your editor:

```bash
cp .env.example .env
```

Then paste in the token you generated in Canvas
(**Account → Settings → Approved Integrations → + New Access Token**):

```
CANVAS_API_TOKEN=13~yourReallyLongTokenGoesHere
CANVAS_BASE_URL=https://boisestatecanvas.instructure.com
PORT=3000
```

> **Your token is a password.** It grants full access to your Canvas account.
> `.env` is listed in [`.gitignore`](.gitignore) so git will not track it. If you
> ever push a token by accident, delete it in Canvas *immediately* and generate a
> new one. Rewriting git history is not enough, because the old value is already
> in someone's clone.

### 3. Run it
Run in terminal by typing in the following into the terminal:

```bash
./mvnw spring-boot:run
```

Then open <http://localhost:3000>. Stop the server with `Ctrl+C`.

# API Endpoints Used. 
 - /api/v1/courses : Used to list courses.
 - /api/v1/announcements : Used to list course announcements

# Reflection

    I was unfortunately not able to get all aspects of the project complete, but I had a lot of fun figuring out how to get it working. I learned a lot about the specifics of using Java and Springboot, such as how to connect it to an API, create tests, and debug programming errors.

    I also got experience in using AI to help with the development process. At the start, I was very much inexperienced with using AI to assist in development, but after getting help from the instructor to figure out how to get the AI chat bot open in VSCode, I was able to use it to assist both with the development process, and also to help me understand and learn more about how to develop using Java and Springboot.

    If I had given myself more time to work on this, I would have loved to finish the single feature I did not get too figuring out, being handling the error that occurs when trying to run the program without the env file. I would have also loved to add a few more features to the application, such as adding the ability to submit an assignment with it.