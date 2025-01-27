function checkUrl() {
    const url = document.getElementById("urlInput").value;

    if (url === "") {
        document.getElementById("result").innerText = "Please enter a URL.";
        return;
    }

    // Send the URL to the backend API
    fetch("/api/check_url", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ url: url }),
    })
    .then(response => response.json())
    .then(data => {
        const resultElement = document.getElementById("result");
        if (data.isSafe) {
            resultElement.innerText = "This URL is safe.";
            resultElement.style.color = "green";
        } else {
            resultElement.innerText = "This URL is not safe.";
            resultElement.style.color = "red";
        }
    })
    .catch(error => {
        document.getElementById("result").innerText = "Error checking URL.";
    });
}
