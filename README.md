## Spark Project Template
### **Creating a Spark Project Using Giter8 Template**

This tutorial demonstrates how to quickly set up a **Spark Project Template** using the Giter8 template engine. The template simplifies the process of initializing, building, running, and managing a Spark project in Scala. This guide is tailored for GitHub-hosted Giter8 templates.



### **What is Giter8?**
Giter8 is a lightweight templating engine for Scala projects. It allows you to create templates for new projects with customizable settings like project name, Scala version, Spark version, and more.

In this tutorial, we will use the **`osekoo/spark-scala.g8`** template hosted on GitHub to set up a Spark project.



### **Prerequisites**
To successfully use the `spark-scala.g8` template for creating Spark projects, ensure the following tools are installed on your system.


### **1. Java Development Kit (JDK)**
Spark requires Java for execution. Install **JDK 8** or later.
**Download OpenJDK**  
- [AdoptOpenJDK (Temurin)](https://adoptium.net/temurin): Free, open-source, and widely used JDK distribution.

**Direct Links**:
- **Windows**: [Download Windows MSI Installer](https://adoptium.net/temurin/releases/?version=8)
- **macOS**: [Download macOS DMG Installer](https://adoptium.net/temurin/releases/?version=8)
- **Linux**:
  - Use your package manager to install OpenJDK:
    ```bash
    sudo apt update
    sudo apt install openjdk-8-jdk
    ```

**Installation Verification**  
After installation, verify JDK by running:
```bash
java -version
```
Expected output:
```text
java version "1.8.0_xxx"
Java(TM) SE Runtime Environment (build 1.8.0_xxx)
Java HotSpot(TM) 64-Bit Server VM (build 25.XXX-bXX, mixed mode)
```


### **2. Scala Build Tool (SBT)**
- Download and install **SBT** from the [official website](https://www.scala-sbt.org/download/).
- Verify the installation:
  ```bash
  sbt --version
  ```
  Example Output:
  ```text
  sbt version in this project: 1.9.4
  sbt script version: 1.9.4
  ```


### **3. Docker**
Docker is required to run Spark clusters and manage containers for services like Kafka.

#### **Install Docker**
- **Windows and macOS**:
  - Download **Docker Desktop** from [https://www.docker.com/products/docker-desktop/](https://www.docker.com/products/docker-desktop/).
  - Follow the installation steps.
  - Verify the installation:
    ```bash
    docker --version
    ```
    Example Output:
    ```text
    Docker version 20.10.12, build e91ed57
    ```

- **Linux**:
  1. Update package index:
     ```bash
     sudo apt-get update
     ```
  2. Install Docker:
     ```bash
     sudo apt-get install -y docker.io
     ```
  3. Add your user to the Docker group (optional, to avoid using `sudo`):
     ```bash
     sudo usermod -aG docker $USER
     ```
     Log out and log back in for the changes to take effect.
  4. Verify the installation:
     ```bash
     docker --version
     ```


### **5. Verify All Prerequisites**
Run the following commands to ensure everything is set up correctly:
```bash
java -version       # Verify JDK
sbt --version      # Verify SBT
docker --version    # Verify Docker
```


With these tools installed, you'll be able to create, build, and run Spark projects seamlessly using the `spark-scala.g8` template. If you encounter any issues, feel free to ask for assistance!



### **Steps to Create and Run a Spark Project**

#### **1. Create a New Project**
Run the following command in your terminal:
```bash
sbt new osekoo/spark-scala.g8
```

This command downloads and executes the `osekoo/spark-scala.g8` template from GitHub. During execution:
- You’ll be prompted to specify project details, such as:
  - **Project name** (e.g., `MySparkApp`).
  - **Scala version** (e.g., `2.12.18`).
  - **Spark version** (e.g., `3.5.2`).

Once completed, a new project folder named after your specified project will be created.



#### **2. Navigate to the Project Directory**
Move into the project directory:
```bash
cd <project_name>
```

Replace `<project_name>` with the name of your project (e.g., `MySparkApp`).



#### **3. Build the Project**
To compile and package your Spark application, run:
```bash
sbt package
```

This will create a JAR file in the `target/scala-<version>/` directory. The JAR contains your Spark application and all dependencies.



#### **4.1 Run the Spark Environment**
Execute your Spark environement (cluster) with the preconfigured `spark-env` script:
```bash
spark-env
```

This script starts a local Spark cluster (master and worker).



#### **4.2 Run the Project**
From the above Spark environment, execute your Spark application with the preconfigured `spark-submit-job` script:
```bash
spark-submit-job
```

This script submits your Spark application.



#### **5. Monitor the Application**
While the Spark application is running, you can monitor its progress through the Spark UI:
- Open your browser and navigate to:
  ```text
  http://localhost:8080
  ```

The Spark UI provides details about job execution, tasks, and cluster status.



#### **6. Stop the Spark Cluster**
Once your Spark application has finished or you want to shut down the cluster, run:
```bash
exit
```

This script gracefully stops the Spark cluster.



### **Project Workflow Recap**
1. **Create a Project**:  
   ```bash
   sbt new osekoo/spark-scala.g8
   ```
2. **Navigate to the Project Directory**:  
   ```bash
   cd <project_name>
   ```
3. **Build the Project**:  
   ```bash
   sbt package
   ```
4. **Run the Application**:  
   ```bash
   ./spark-env
   ```
5. **Monitor the Application**:  
   View the Spark UI at [http://localhost:8080](http://localhost:8080).
6. **Stop the Cluster**:  
   ```bash
   exit
   ```


### **Benefits of Using Giter8 Templates**
- **Consistency**: Quickly set up projects with consistent structure and dependencies.
- **Customization**: Preconfigure settings like Spark/Scala versions and default scripts.
- **Ease of Use**: Avoid repetitive setup tasks with a single command.


### **Editing Your Spark Project**

Once you’ve created your Spark project, you can edit it using your favorite Integrated Development Environment (IDE) like **Visual Studio Code** or **IntelliJ IDEA**. Both IDEs provide excellent support for Scala, SBT, and Spark development.



#### **1. Editing with Visual Studio Code**
Visual Studio Code (VS Code) is a lightweight IDE with robust support for Scala development when paired with the appropriate extensions.

##### **Steps to Edit with VS Code**
1. **Open the Project in VS Code**:
   - Launch VS Code.
   - Open the project folder created during the Giter8 setup:
     ```bash
     code <project_name>
     ```

2. **Install Required Extensions**:
   - Go to the Extensions Marketplace in VS Code.
   - Search for and install the following:
     - **Metals**: Scala language server for intelligent code completion, error checking, and more.
     - **Scala (Language Server Protocol)**: For Scala syntax highlighting.

3. **Import the Project**:
   - After opening the project, VS Code will prompt you to import the SBT build. Click **Import Build** to let Metals set up the project.

4. **Start Editing**:
   - Navigate to `src/main/scala/` to edit or add Scala source files for your Spark application.



#### **2. Editing with IntelliJ IDEA**
IntelliJ IDEA is a powerful IDE for JVM-based languages like Scala. It provides robust features like intelligent code completion, debugging, and integration with SBT.

##### **Steps to Edit with IntelliJ IDEA**
1. **Install IntelliJ IDEA**:
   - Download and install IntelliJ IDEA (Community or Ultimate Edition) from [JetBrains](https://www.jetbrains.com/idea/download/).

2. **Install the Scala Plugin**:
   - Open IntelliJ IDEA and go to **File > Settings > Plugins**.
   - Search for and install the **Scala** plugin.
   - Restart IntelliJ IDEA to activate the plugin.

3. **Import Your Project**:
   - Click **Open** from the IntelliJ IDEA welcome screen.
   - Select the root folder of your project.
   - IntelliJ will detect the SBT project and prompt you to import it. Click **Import**.

4. **Configure the SBT Settings**:
   - Ensure that IntelliJ uses the correct JDK (e.g., JDK 8 or 11, depending on your Spark version).
   - Let IntelliJ index the project, which may take a few minutes.

5. **Start Editing**:
   - Navigate to the `src/main/scala/` folder to edit or create Scala files.


#### **Best Practices for IDE Usage**
- **Code Style**: Use consistent Scala formatting tools like **Scalafmt** (can be integrated with Metals or IntelliJ).
- **Testing**: Write unit tests for your Spark application and run them using SBT (`sbt test`) or your IDE.
- **Version Control**: Use Git for version control. Both VS Code and IntelliJ have built-in Git integrations for managing repositories.

By using a powerful IDE, you can enhance your productivity and streamline the process of developing, testing, and debugging your Spark project.
