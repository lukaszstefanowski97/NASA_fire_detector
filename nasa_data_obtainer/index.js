const express = require('express');
const app = express();
const request = require('request');
const fs = require('file-system');
const csv = require('csvtojson');
const cors = require('cors');

app.use(cors());

setInterval(function () {
    request({
        url: "https://firms.modaps.eosdis.nasa.gov/data/active_fire/c6/csv/MODIS_C6_Europe_24h.csv",
        method: "GET",
        timeout: 10000,
        followRedirect: true,
        maxRedirects: 10
    }, function (error, response, body) {
        if (!error && response.statusCode === 200) {
            console.log('Fetched data from NASA fire API...');
            fs.writeFile('data/europe.csv', body, function (err) {
                if (err) {
                    return console.log(err);
                }

                console.log("The file was saved!");
            });
        } else {
            console.log('Error: did not fetch NASA fire API data');
        }
    });
}, 60000);

app.get('/api/europe', (req, res) => {
    csv()
        .fromFile('data/europe.csv')
        .then((jsonObj) => {
            jsonObj.forEach(function(o){ delete o.brightness, delete o.scan, delete o.track, delete o.acq_date,
                                                    delete o.acq_time, delete o.satellite, delete o.version,
                                                    delete o.bright_t31, delete o.frp, delete o.daynight});
            res.send(jsonObj);
            console.log('Getting NASA data...');
        });
});

app.listen(80, () => console.log('Application started...'));
