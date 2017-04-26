var execSync = require('child_process').execSync;
var http = require('http');
var fs = require('fs');

function runTest(data) {
    return new Promise(
        function (resolve, reject) {
            var cmd = './gradlew regression';
            console.log(cmd)
            let environment = process.env;
            var runData = data.join("|");
            console.log(runData)
            environment.DATA = runData;
            var history = execSync(cmd, { encoding: 'utf8', env: environment });
            console.log(history);
        });
}

function getRegreesionInfo(callback) {
    http.get("http://" + process.env.MGP + "/api/regression/uat/" + process.env.TARGET, function (res) {
        var body = ''; // Will contain the final response
        // Received data is a buffer.
        // Adding it to our body
        res.on('data', function (data) {
            body += data;
        });
        // After the response is completed, parse it and log it to the console
        res.on('end', function () {
            var parsed = JSON.parse(body);
            console.log("recevice:", body);
            callback(parsed);
        });
    })
        // If any error has occured, log error to console
        .on('error', function (e) {
            console.log("Got error: " + e.message);
        });
}

function renameTest() {
    return new Promise(
        function (resolve, reject) {
            const reportFolder = './build/cucumber';
            fs.readdir(reportFolder, (err, files) => {
                console.log(files)
                files.forEach(file => {
                    if (!file.startsWith("_")) {
                        fs.renameSync(`${reportFolder}/${file}`, `${reportFolder}/_${time}_${file}`);
                    }
                    resolve();
                });
            })
        });
}


function runStretegy(data) {
    execSync('rm -rf build');
    console.log(data)
    for (let item of data) {
        runTest(item);
    }
}

getRegreesionInfo(runStretegy);