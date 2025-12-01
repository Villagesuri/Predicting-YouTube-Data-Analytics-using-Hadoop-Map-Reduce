# 📊 YouTube Data Analysis using Hadoop MapReduce

This project performs **categorical analysis of YouTube video data** using Hadoop MapReduce.
It reads a CSV dataset, extracts the **video category** and its **view count**, and computes the **total views per category**.

---

## 🚀 Project Structure

```
├── YouTubeDataAnalysis.java   # Driver (Main) program
├── YouTubeMapper.java         # Mapper class
├── YouTubeReducer.java        # Reducer class
└── input/                     # Dataset (CSV)
```

---

## 🧩 How It Works

### **1️⃣ Driver Code – YouTubeDataAnalysis.java**

* Creates a Hadoop configuration.
* Initializes the MapReduce job named **"YouTube Data Analytics"**.
* Specifies the **Mapper** and **Reducer** classes.
* Sets output key and value types (`Text`, `IntWritable`).
* Reads input path and output path from command-line arguments.
* Submits the job and waits for completion.

---

### **2️⃣ Mapper – YouTubeMapper.java**

* Processes each line of the input CSV file.
* Splits the line by comma.
* Extracts:

  * **Category** → `fields[3]`
  * **View Count** → `fields[4]`
* Converts view count into integer.
* Emits:

  * **Key:** Category
  * **Value:** View count
* Skips rows with invalid or missing data using `try-catch`.

---

### **3️⃣ Reducer – YouTubeReducer.java**

* Receives each **category** with a list of **view counts**.
* Iterates over all values and calculates:

  * **Total views per category**
* Writes:

  * **Category → Total View Count**

---

## 📌 Example Output

```
Music      23849384
Sports     10938493
Comedy      9384930
Education   4593840
```

---

## ▶️ How to Run the Program

### **Step 1: Compile the Java files**

```bash
hadoop com.sun.tools.javac.Main *.java
jar cf youtube.jar *.class
```

### **Step 2: Run on Hadoop**

```bash
hadoop jar youtube.jar YouTubeDataAnalysis /input/youtube.csv /output/youtube-results
```

---

## 🛠 Technologies Used

* **Java**
* **Hadoop MapReduce**
* **HDFS**
* **CSV Data Processing**

---

## 📄 Description

This Hadoop MapReduce project performs YouTube data aggregation by category.
It is useful for:

* Big data analysis
* Trend analysis
* Category-based statistics
* Understanding viewer behavior

---
