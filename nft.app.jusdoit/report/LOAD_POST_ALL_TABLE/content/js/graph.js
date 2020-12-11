/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
$(document).ready(function() {

    $(".click-title").mouseenter( function(    e){
        e.preventDefault();
        this.style.cursor="pointer";
    });
    $(".click-title").mousedown( function(event){
        event.preventDefault();
    });

    // Ugly code while this script is shared among several pages
    try{
        refreshHitsPerSecond(true);
    } catch(e){}
    try{
        refreshResponseTimeOverTime(true);
    } catch(e){}
    try{
        refreshResponseTimePercentiles();
    } catch(e){}
});


var responseTimePercentilesInfos = {
        data: {"result": {"minY": 41670.0, "minX": 0.0, "maxY": 68042.0, "series": [{"data": [[0.0, 41670.0], [0.1, 41670.0], [0.2, 41670.0], [0.3, 41670.0], [0.4, 41670.0], [0.5, 41670.0], [0.6, 41670.0], [0.7, 41670.0], [0.8, 41670.0], [0.9, 41670.0], [1.0, 41670.0], [1.1, 41670.0], [1.2, 41670.0], [1.3, 41708.0], [1.4, 41708.0], [1.5, 41708.0], [1.6, 41708.0], [1.7, 41708.0], [1.8, 41708.0], [1.9, 41708.0], [2.0, 41708.0], [2.1, 41708.0], [2.2, 41708.0], [2.3, 41708.0], [2.4, 41708.0], [2.5, 41708.0], [2.6, 41938.0], [2.7, 41938.0], [2.8, 41938.0], [2.9, 41938.0], [3.0, 41938.0], [3.1, 41938.0], [3.2, 41938.0], [3.3, 41938.0], [3.4, 41938.0], [3.5, 41938.0], [3.6, 41938.0], [3.7, 41938.0], [3.8, 41997.0], [3.9, 41997.0], [4.0, 41997.0], [4.1, 41997.0], [4.2, 41997.0], [4.3, 41997.0], [4.4, 41997.0], [4.5, 41997.0], [4.6, 41997.0], [4.7, 41997.0], [4.8, 41997.0], [4.9, 41997.0], [5.0, 41997.0], [5.1, 42055.0], [5.2, 42055.0], [5.3, 42055.0], [5.4, 42055.0], [5.5, 42055.0], [5.6, 42055.0], [5.7, 42055.0], [5.8, 42055.0], [5.9, 42055.0], [6.0, 42055.0], [6.1, 42055.0], [6.2, 42055.0], [6.3, 42055.0], [6.4, 42105.0], [6.5, 42105.0], [6.6, 42105.0], [6.7, 42105.0], [6.8, 42105.0], [6.9, 42105.0], [7.0, 42105.0], [7.1, 42105.0], [7.2, 42105.0], [7.3, 42105.0], [7.4, 42105.0], [7.5, 42105.0], [7.6, 42212.0], [7.7, 42212.0], [7.8, 42212.0], [7.9, 42212.0], [8.0, 42212.0], [8.1, 42212.0], [8.2, 42212.0], [8.3, 42212.0], [8.4, 42212.0], [8.5, 42212.0], [8.6, 42212.0], [8.7, 42212.0], [8.8, 42212.0], [8.9, 42226.0], [9.0, 42226.0], [9.1, 42226.0], [9.2, 42226.0], [9.3, 42226.0], [9.4, 42226.0], [9.5, 42226.0], [9.6, 42226.0], [9.7, 42226.0], [9.8, 42226.0], [9.9, 42226.0], [10.0, 42226.0], [10.1, 42226.0], [10.2, 42483.0], [10.3, 42483.0], [10.4, 42483.0], [10.5, 42483.0], [10.6, 42483.0], [10.7, 42483.0], [10.8, 42483.0], [10.9, 42483.0], [11.0, 42483.0], [11.1, 42483.0], [11.2, 42483.0], [11.3, 42483.0], [11.4, 42494.0], [11.5, 42494.0], [11.6, 42494.0], [11.7, 42494.0], [11.8, 42494.0], [11.9, 42494.0], [12.0, 42494.0], [12.1, 42494.0], [12.2, 42494.0], [12.3, 42494.0], [12.4, 42494.0], [12.5, 42494.0], [12.6, 42494.0], [12.7, 42539.0], [12.8, 42539.0], [12.9, 42539.0], [13.0, 42539.0], [13.1, 42539.0], [13.2, 42539.0], [13.3, 42539.0], [13.4, 42539.0], [13.5, 42539.0], [13.6, 42539.0], [13.7, 42539.0], [13.8, 42539.0], [13.9, 42539.0], [14.0, 42580.0], [14.1, 42580.0], [14.2, 42580.0], [14.3, 42580.0], [14.4, 42580.0], [14.5, 42580.0], [14.6, 42580.0], [14.7, 42580.0], [14.8, 42580.0], [14.9, 42580.0], [15.0, 42580.0], [15.1, 42580.0], [15.2, 42602.0], [15.3, 42602.0], [15.4, 42602.0], [15.5, 42602.0], [15.6, 42602.0], [15.7, 42602.0], [15.8, 42602.0], [15.9, 42602.0], [16.0, 42602.0], [16.1, 42602.0], [16.2, 42602.0], [16.3, 42602.0], [16.4, 42602.0], [16.5, 42617.0], [16.6, 42617.0], [16.7, 42617.0], [16.8, 42617.0], [16.9, 42617.0], [17.0, 42617.0], [17.1, 42617.0], [17.2, 42617.0], [17.3, 42617.0], [17.4, 42617.0], [17.5, 42617.0], [17.6, 42617.0], [17.7, 42617.0], [17.8, 42665.0], [17.9, 42665.0], [18.0, 42665.0], [18.1, 42665.0], [18.2, 42665.0], [18.3, 42665.0], [18.4, 42665.0], [18.5, 42665.0], [18.6, 42665.0], [18.7, 42665.0], [18.8, 42665.0], [18.9, 42665.0], [19.0, 42728.0], [19.1, 42728.0], [19.2, 42728.0], [19.3, 42728.0], [19.4, 42728.0], [19.5, 42728.0], [19.6, 42728.0], [19.7, 42728.0], [19.8, 42728.0], [19.9, 42728.0], [20.0, 42728.0], [20.1, 42728.0], [20.2, 42728.0], [20.3, 42731.0], [20.4, 42731.0], [20.5, 42731.0], [20.6, 42731.0], [20.7, 42731.0], [20.8, 42731.0], [20.9, 42731.0], [21.0, 42731.0], [21.1, 42731.0], [21.2, 42731.0], [21.3, 42731.0], [21.4, 42731.0], [21.5, 42731.0], [21.6, 42744.0], [21.7, 42744.0], [21.8, 42744.0], [21.9, 42744.0], [22.0, 42744.0], [22.1, 42744.0], [22.2, 42744.0], [22.3, 42744.0], [22.4, 42744.0], [22.5, 42744.0], [22.6, 42744.0], [22.7, 42744.0], [22.8, 42756.0], [22.9, 42756.0], [23.0, 42756.0], [23.1, 42756.0], [23.2, 42756.0], [23.3, 42756.0], [23.4, 42756.0], [23.5, 42756.0], [23.6, 42756.0], [23.7, 42756.0], [23.8, 42756.0], [23.9, 42756.0], [24.0, 42756.0], [24.1, 42772.0], [24.2, 42772.0], [24.3, 42772.0], [24.4, 42772.0], [24.5, 42772.0], [24.6, 42772.0], [24.7, 42772.0], [24.8, 42772.0], [24.9, 42772.0], [25.0, 42772.0], [25.1, 42772.0], [25.2, 42772.0], [25.3, 42772.0], [25.4, 42839.0], [25.5, 42839.0], [25.6, 42839.0], [25.7, 42839.0], [25.8, 42839.0], [25.9, 42839.0], [26.0, 42839.0], [26.1, 42839.0], [26.2, 42839.0], [26.3, 42839.0], [26.4, 42839.0], [26.5, 42839.0], [26.6, 42855.0], [26.7, 42855.0], [26.8, 42855.0], [26.9, 42855.0], [27.0, 42855.0], [27.1, 42855.0], [27.2, 42855.0], [27.3, 42855.0], [27.4, 42855.0], [27.5, 42855.0], [27.6, 42855.0], [27.7, 42855.0], [27.8, 42855.0], [27.9, 42894.0], [28.0, 42894.0], [28.1, 42894.0], [28.2, 42894.0], [28.3, 42894.0], [28.4, 42894.0], [28.5, 42894.0], [28.6, 42894.0], [28.7, 42894.0], [28.8, 42894.0], [28.9, 42894.0], [29.0, 42894.0], [29.1, 42894.0], [29.2, 43003.0], [29.3, 43003.0], [29.4, 43003.0], [29.5, 43003.0], [29.6, 43003.0], [29.7, 43003.0], [29.8, 43003.0], [29.9, 43003.0], [30.0, 43003.0], [30.1, 43003.0], [30.2, 43003.0], [30.3, 43003.0], [30.4, 43021.0], [30.5, 43021.0], [30.6, 43021.0], [30.7, 43021.0], [30.8, 43021.0], [30.9, 43021.0], [31.0, 43021.0], [31.1, 43021.0], [31.2, 43021.0], [31.3, 43021.0], [31.4, 43021.0], [31.5, 43021.0], [31.6, 43021.0], [31.7, 43083.0], [31.8, 43083.0], [31.9, 43083.0], [32.0, 43083.0], [32.1, 43083.0], [32.2, 43083.0], [32.3, 43083.0], [32.4, 43083.0], [32.5, 43083.0], [32.6, 43083.0], [32.7, 43083.0], [32.8, 43083.0], [32.9, 43083.0], [33.0, 43338.0], [33.1, 43338.0], [33.2, 43338.0], [33.3, 43338.0], [33.4, 43338.0], [33.5, 43338.0], [33.6, 43338.0], [33.7, 43338.0], [33.8, 43338.0], [33.9, 43338.0], [34.0, 43338.0], [34.1, 43338.0], [34.2, 43932.0], [34.3, 43932.0], [34.4, 43932.0], [34.5, 43932.0], [34.6, 43932.0], [34.7, 43932.0], [34.8, 43932.0], [34.9, 43932.0], [35.0, 43932.0], [35.1, 43932.0], [35.2, 43932.0], [35.3, 43932.0], [35.4, 43932.0], [35.5, 44087.0], [35.6, 44087.0], [35.7, 44087.0], [35.8, 44087.0], [35.9, 44087.0], [36.0, 44087.0], [36.1, 44087.0], [36.2, 44087.0], [36.3, 44087.0], [36.4, 44087.0], [36.5, 44087.0], [36.6, 44087.0], [36.7, 44087.0], [36.8, 44757.0], [36.9, 44757.0], [37.0, 44757.0], [37.1, 44757.0], [37.2, 44757.0], [37.3, 44757.0], [37.4, 44757.0], [37.5, 44757.0], [37.6, 44757.0], [37.7, 44757.0], [37.8, 44757.0], [37.9, 44757.0], [38.0, 44805.0], [38.1, 44805.0], [38.2, 44805.0], [38.3, 44805.0], [38.4, 44805.0], [38.5, 44805.0], [38.6, 44805.0], [38.7, 44805.0], [38.8, 44805.0], [38.9, 44805.0], [39.0, 44805.0], [39.1, 44805.0], [39.2, 44805.0], [39.3, 44923.0], [39.4, 44923.0], [39.5, 44923.0], [39.6, 44923.0], [39.7, 44923.0], [39.8, 44923.0], [39.9, 44923.0], [40.0, 44923.0], [40.1, 44923.0], [40.2, 44923.0], [40.3, 44923.0], [40.4, 44923.0], [40.5, 44923.0], [40.6, 45259.0], [40.7, 45259.0], [40.8, 45259.0], [40.9, 45259.0], [41.0, 45259.0], [41.1, 45259.0], [41.2, 45259.0], [41.3, 45259.0], [41.4, 45259.0], [41.5, 45259.0], [41.6, 45259.0], [41.7, 45259.0], [41.8, 45437.0], [41.9, 45437.0], [42.0, 45437.0], [42.1, 45437.0], [42.2, 45437.0], [42.3, 45437.0], [42.4, 45437.0], [42.5, 45437.0], [42.6, 45437.0], [42.7, 45437.0], [42.8, 45437.0], [42.9, 45437.0], [43.0, 45437.0], [43.1, 45473.0], [43.2, 45473.0], [43.3, 45473.0], [43.4, 45473.0], [43.5, 45473.0], [43.6, 45473.0], [43.7, 45473.0], [43.8, 45473.0], [43.9, 45473.0], [44.0, 45473.0], [44.1, 45473.0], [44.2, 45473.0], [44.3, 45473.0], [44.4, 45511.0], [44.5, 45511.0], [44.6, 45511.0], [44.7, 45511.0], [44.8, 45511.0], [44.9, 45511.0], [45.0, 45511.0], [45.1, 45511.0], [45.2, 45511.0], [45.3, 45511.0], [45.4, 45511.0], [45.5, 45511.0], [45.6, 45591.0], [45.7, 45591.0], [45.8, 45591.0], [45.9, 45591.0], [46.0, 45591.0], [46.1, 45591.0], [46.2, 45591.0], [46.3, 45591.0], [46.4, 45591.0], [46.5, 45591.0], [46.6, 45591.0], [46.7, 45591.0], [46.8, 45591.0], [46.9, 45669.0], [47.0, 45669.0], [47.1, 45669.0], [47.2, 45669.0], [47.3, 45669.0], [47.4, 45669.0], [47.5, 45669.0], [47.6, 45669.0], [47.7, 45669.0], [47.8, 45669.0], [47.9, 45669.0], [48.0, 45669.0], [48.1, 45669.0], [48.2, 45743.0], [48.3, 45743.0], [48.4, 45743.0], [48.5, 45743.0], [48.6, 45743.0], [48.7, 45743.0], [48.8, 45743.0], [48.9, 45743.0], [49.0, 45743.0], [49.1, 45743.0], [49.2, 45743.0], [49.3, 45743.0], [49.4, 45759.0], [49.5, 45759.0], [49.6, 45759.0], [49.7, 45759.0], [49.8, 45759.0], [49.9, 45759.0], [50.0, 45759.0], [50.1, 45759.0], [50.2, 45759.0], [50.3, 45759.0], [50.4, 45759.0], [50.5, 45759.0], [50.6, 45759.0], [50.7, 45774.0], [50.8, 45774.0], [50.9, 45774.0], [51.0, 45774.0], [51.1, 45774.0], [51.2, 45774.0], [51.3, 45774.0], [51.4, 45774.0], [51.5, 45774.0], [51.6, 45774.0], [51.7, 45774.0], [51.8, 45774.0], [51.9, 45792.0], [52.0, 45792.0], [52.1, 45792.0], [52.2, 45792.0], [52.3, 45792.0], [52.4, 45792.0], [52.5, 45792.0], [52.6, 45792.0], [52.7, 45792.0], [52.8, 45792.0], [52.9, 45792.0], [53.0, 45792.0], [53.1, 45792.0], [53.2, 45844.0], [53.3, 45844.0], [53.4, 45844.0], [53.5, 45844.0], [53.6, 45844.0], [53.7, 45844.0], [53.8, 45844.0], [53.9, 45844.0], [54.0, 45844.0], [54.1, 45844.0], [54.2, 45844.0], [54.3, 45844.0], [54.4, 45844.0], [54.5, 45844.0], [54.6, 45844.0], [54.7, 45844.0], [54.8, 45844.0], [54.9, 45844.0], [55.0, 45844.0], [55.1, 45844.0], [55.2, 45844.0], [55.3, 45844.0], [55.4, 45844.0], [55.5, 45844.0], [55.6, 45844.0], [55.7, 45966.0], [55.8, 45966.0], [55.9, 45966.0], [56.0, 45966.0], [56.1, 45966.0], [56.2, 45966.0], [56.3, 45966.0], [56.4, 45966.0], [56.5, 45966.0], [56.6, 45966.0], [56.7, 45966.0], [56.8, 45966.0], [56.9, 45966.0], [57.0, 45971.0], [57.1, 45971.0], [57.2, 45971.0], [57.3, 45971.0], [57.4, 45971.0], [57.5, 45971.0], [57.6, 45971.0], [57.7, 45971.0], [57.8, 45971.0], [57.9, 45971.0], [58.0, 45971.0], [58.1, 45971.0], [58.2, 45971.0], [58.3, 46004.0], [58.4, 46004.0], [58.5, 46004.0], [58.6, 46004.0], [58.7, 46004.0], [58.8, 46004.0], [58.9, 46004.0], [59.0, 46004.0], [59.1, 46004.0], [59.2, 46004.0], [59.3, 46004.0], [59.4, 46004.0], [59.5, 46039.0], [59.6, 46039.0], [59.7, 46039.0], [59.8, 46039.0], [59.9, 46039.0], [60.0, 46039.0], [60.1, 46039.0], [60.2, 46039.0], [60.3, 46039.0], [60.4, 46039.0], [60.5, 46039.0], [60.6, 46039.0], [60.7, 46039.0], [60.8, 46091.0], [60.9, 46091.0], [61.0, 46091.0], [61.1, 46091.0], [61.2, 46091.0], [61.3, 46091.0], [61.4, 46091.0], [61.5, 46091.0], [61.6, 46091.0], [61.7, 46091.0], [61.8, 46091.0], [61.9, 46091.0], [62.0, 46091.0], [62.1, 46200.0], [62.2, 46200.0], [62.3, 46200.0], [62.4, 46200.0], [62.5, 46200.0], [62.6, 46200.0], [62.7, 46200.0], [62.8, 46200.0], [62.9, 46200.0], [63.0, 46200.0], [63.1, 46200.0], [63.2, 46200.0], [63.3, 46219.0], [63.4, 46219.0], [63.5, 46219.0], [63.6, 46219.0], [63.7, 46219.0], [63.8, 46219.0], [63.9, 46219.0], [64.0, 46219.0], [64.1, 46219.0], [64.2, 46219.0], [64.3, 46219.0], [64.4, 46219.0], [64.5, 46219.0], [64.6, 46298.0], [64.7, 46298.0], [64.8, 46298.0], [64.9, 46298.0], [65.0, 46298.0], [65.1, 46298.0], [65.2, 46298.0], [65.3, 46298.0], [65.4, 46298.0], [65.5, 46298.0], [65.6, 46298.0], [65.7, 46298.0], [65.8, 46298.0], [65.9, 46358.0], [66.0, 46358.0], [66.1, 46358.0], [66.2, 46358.0], [66.3, 46358.0], [66.4, 46358.0], [66.5, 46358.0], [66.6, 46358.0], [66.7, 46358.0], [66.8, 46358.0], [66.9, 46358.0], [67.0, 46358.0], [67.1, 46503.0], [67.2, 46503.0], [67.3, 46503.0], [67.4, 46503.0], [67.5, 46503.0], [67.6, 46503.0], [67.7, 46503.0], [67.8, 46503.0], [67.9, 46503.0], [68.0, 46503.0], [68.1, 46503.0], [68.2, 46503.0], [68.3, 46503.0], [68.4, 46525.0], [68.5, 46525.0], [68.6, 46525.0], [68.7, 46525.0], [68.8, 46525.0], [68.9, 46525.0], [69.0, 46525.0], [69.1, 46525.0], [69.2, 46525.0], [69.3, 46525.0], [69.4, 46525.0], [69.5, 46525.0], [69.6, 46525.0], [69.7, 46536.0], [69.8, 46536.0], [69.9, 46536.0], [70.0, 46536.0], [70.1, 46536.0], [70.2, 46536.0], [70.3, 46536.0], [70.4, 46536.0], [70.5, 46536.0], [70.6, 46536.0], [70.7, 46536.0], [70.8, 46536.0], [70.9, 46587.0], [71.0, 46587.0], [71.1, 46587.0], [71.2, 46587.0], [71.3, 46587.0], [71.4, 46587.0], [71.5, 46587.0], [71.6, 46587.0], [71.7, 46587.0], [71.8, 46587.0], [71.9, 46587.0], [72.0, 46587.0], [72.1, 46587.0], [72.2, 46658.0], [72.3, 46658.0], [72.4, 46658.0], [72.5, 46658.0], [72.6, 46658.0], [72.7, 46658.0], [72.8, 46658.0], [72.9, 46658.0], [73.0, 46658.0], [73.1, 46658.0], [73.2, 46658.0], [73.3, 46658.0], [73.4, 46658.0], [73.5, 46737.0], [73.6, 46737.0], [73.7, 46737.0], [73.8, 46737.0], [73.9, 46737.0], [74.0, 46737.0], [74.1, 46737.0], [74.2, 46737.0], [74.3, 46737.0], [74.4, 46737.0], [74.5, 46737.0], [74.6, 46737.0], [74.7, 46803.0], [74.8, 46803.0], [74.9, 46803.0], [75.0, 46803.0], [75.1, 46803.0], [75.2, 46803.0], [75.3, 46803.0], [75.4, 46803.0], [75.5, 46803.0], [75.6, 46803.0], [75.7, 46803.0], [75.8, 46803.0], [75.9, 46803.0], [76.0, 47003.0], [76.1, 47003.0], [76.2, 47003.0], [76.3, 47003.0], [76.4, 47003.0], [76.5, 47003.0], [76.6, 47003.0], [76.7, 47003.0], [76.8, 47003.0], [76.9, 47003.0], [77.0, 47003.0], [77.1, 47003.0], [77.2, 47003.0], [77.3, 47091.0], [77.4, 47091.0], [77.5, 47091.0], [77.6, 47091.0], [77.7, 47091.0], [77.8, 47091.0], [77.9, 47091.0], [78.0, 47091.0], [78.1, 47091.0], [78.2, 47091.0], [78.3, 47091.0], [78.4, 47091.0], [78.5, 47171.0], [78.6, 47171.0], [78.7, 47171.0], [78.8, 47171.0], [78.9, 47171.0], [79.0, 47171.0], [79.1, 47171.0], [79.2, 47171.0], [79.3, 47171.0], [79.4, 47171.0], [79.5, 47171.0], [79.6, 47171.0], [79.7, 47171.0], [79.8, 47299.0], [79.9, 47299.0], [80.0, 47299.0], [80.1, 47299.0], [80.2, 47299.0], [80.3, 47299.0], [80.4, 47299.0], [80.5, 47299.0], [80.6, 47299.0], [80.7, 47299.0], [80.8, 47299.0], [80.9, 47299.0], [81.0, 47299.0], [81.1, 47483.0], [81.2, 47483.0], [81.3, 47483.0], [81.4, 47483.0], [81.5, 47483.0], [81.6, 47483.0], [81.7, 47483.0], [81.8, 47483.0], [81.9, 47483.0], [82.0, 47483.0], [82.1, 47483.0], [82.2, 47483.0], [82.3, 47539.0], [82.4, 47539.0], [82.5, 47539.0], [82.6, 47539.0], [82.7, 47539.0], [82.8, 47539.0], [82.9, 47539.0], [83.0, 47539.0], [83.1, 47539.0], [83.2, 47539.0], [83.3, 47539.0], [83.4, 47539.0], [83.5, 47539.0], [83.6, 47687.0], [83.7, 47687.0], [83.8, 47687.0], [83.9, 47687.0], [84.0, 47687.0], [84.1, 47687.0], [84.2, 47687.0], [84.3, 47687.0], [84.4, 47687.0], [84.5, 47687.0], [84.6, 47687.0], [84.7, 47687.0], [84.8, 47687.0], [84.9, 48778.0], [85.0, 48778.0], [85.1, 48778.0], [85.2, 48778.0], [85.3, 48778.0], [85.4, 48778.0], [85.5, 48778.0], [85.6, 48778.0], [85.7, 48778.0], [85.8, 48778.0], [85.9, 48778.0], [86.0, 48778.0], [86.1, 49093.0], [86.2, 49093.0], [86.3, 49093.0], [86.4, 49093.0], [86.5, 49093.0], [86.6, 49093.0], [86.7, 49093.0], [86.8, 49093.0], [86.9, 49093.0], [87.0, 49093.0], [87.1, 49093.0], [87.2, 49093.0], [87.3, 49093.0], [87.4, 49592.0], [87.5, 49592.0], [87.6, 49592.0], [87.7, 49592.0], [87.8, 49592.0], [87.9, 49592.0], [88.0, 49592.0], [88.1, 49592.0], [88.2, 49592.0], [88.3, 49592.0], [88.4, 49592.0], [88.5, 49592.0], [88.6, 49592.0], [88.7, 49656.0], [88.8, 49656.0], [88.9, 49656.0], [89.0, 49656.0], [89.1, 49656.0], [89.2, 49656.0], [89.3, 49656.0], [89.4, 49656.0], [89.5, 49656.0], [89.6, 49656.0], [89.7, 49656.0], [89.8, 49656.0], [89.9, 49756.0], [90.0, 49756.0], [90.1, 49756.0], [90.2, 49756.0], [90.3, 49756.0], [90.4, 49756.0], [90.5, 49756.0], [90.6, 49756.0], [90.7, 49756.0], [90.8, 49756.0], [90.9, 49756.0], [91.0, 49756.0], [91.1, 49756.0], [91.2, 51221.0], [91.3, 51221.0], [91.4, 51221.0], [91.5, 51221.0], [91.6, 51221.0], [91.7, 51221.0], [91.8, 51221.0], [91.9, 51221.0], [92.0, 51221.0], [92.1, 51221.0], [92.2, 51221.0], [92.3, 51221.0], [92.4, 51221.0], [92.5, 51416.0], [92.6, 51416.0], [92.7, 51416.0], [92.8, 51416.0], [92.9, 51416.0], [93.0, 51416.0], [93.1, 51416.0], [93.2, 51416.0], [93.3, 51416.0], [93.4, 51416.0], [93.5, 51416.0], [93.6, 51416.0], [93.7, 55084.0], [93.8, 55084.0], [93.9, 55084.0], [94.0, 55084.0], [94.1, 55084.0], [94.2, 55084.0], [94.3, 55084.0], [94.4, 55084.0], [94.5, 55084.0], [94.6, 55084.0], [94.7, 55084.0], [94.8, 55084.0], [94.9, 55084.0], [95.0, 57396.0], [95.1, 57396.0], [95.2, 57396.0], [95.3, 57396.0], [95.4, 57396.0], [95.5, 57396.0], [95.6, 57396.0], [95.7, 57396.0], [95.8, 57396.0], [95.9, 57396.0], [96.0, 57396.0], [96.1, 57396.0], [96.2, 57396.0], [96.3, 58877.0], [96.4, 58877.0], [96.5, 58877.0], [96.6, 58877.0], [96.7, 58877.0], [96.8, 58877.0], [96.9, 58877.0], [97.0, 58877.0], [97.1, 58877.0], [97.2, 58877.0], [97.3, 58877.0], [97.4, 58877.0], [97.5, 64814.0], [97.6, 64814.0], [97.7, 64814.0], [97.8, 64814.0], [97.9, 64814.0], [98.0, 64814.0], [98.1, 64814.0], [98.2, 64814.0], [98.3, 64814.0], [98.4, 64814.0], [98.5, 64814.0], [98.6, 64814.0], [98.7, 64814.0], [98.8, 68042.0], [98.9, 68042.0], [99.0, 68042.0], [99.1, 68042.0], [99.2, 68042.0], [99.3, 68042.0], [99.4, 68042.0], [99.5, 68042.0], [99.6, 68042.0], [99.7, 68042.0], [99.8, 68042.0], [99.9, 68042.0]], "isOverall": false, "label": "ALL POST\'s", "isController": false}], "supportsControllersDiscrimination": true, "maxX": 100.0, "title": "Response Time Percentiles"}},
        getOptions: function() {
            return {
                series: {
                    points: { show: false }
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimePercentiles'
                },
                xaxis: {
                    tickDecimals: 1,
                    axisLabel: "Percentiles",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Percentile value in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : %x.2 percentile was %y ms"
                },
                selection: { mode: "xy" },
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesResponseTimePercentiles"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimesPercentiles"), dataset, options);
            // setup overview
            $.plot($("#overviewResponseTimesPercentiles"), dataset, prepareOverviewOptions(options));
        }
};

/**
 * @param elementId Id of element where we display message
 */
function setEmptyGraph(elementId) {
    $(function() {
        $(elementId).text("No graph series with filter="+seriesFilter);
    });
}

// Response times percentiles
function refreshResponseTimePercentiles() {
    var infos = responseTimePercentilesInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimePercentiles");
        return;
    }
    if (isGraph($("#flotResponseTimesPercentiles"))){
        infos.createGraph();
    } else {
        var choiceContainer = $("#choicesResponseTimePercentiles");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimesPercentiles", "#overviewResponseTimesPercentiles");
        $('#bodyResponseTimePercentiles .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var responseTimeDistributionInfos = {
        data: {"result": {"minY": 1.0, "minX": 41600.0, "maxY": 5.0, "series": [{"data": [[42700.0, 5.0], [41900.0, 2.0], [42200.0, 2.0], [41700.0, 1.0], [42000.0, 1.0], [42100.0, 1.0], [42400.0, 2.0], [42500.0, 2.0], [42800.0, 3.0], [43000.0, 3.0], [42600.0, 3.0], [41600.0, 1.0], [44800.0, 1.0], [44900.0, 1.0], [43300.0, 1.0], [44700.0, 1.0], [43900.0, 1.0], [44000.0, 1.0], [45400.0, 2.0], [46200.0, 3.0], [45700.0, 4.0], [45600.0, 1.0], [45800.0, 2.0], [45900.0, 2.0], [46000.0, 3.0], [46500.0, 4.0], [46300.0, 1.0], [47000.0, 2.0], [47100.0, 1.0], [45200.0, 1.0], [46800.0, 1.0], [45500.0, 2.0], [46600.0, 1.0], [46700.0, 1.0], [47400.0, 1.0], [49000.0, 1.0], [48700.0, 1.0], [47500.0, 1.0], [47600.0, 1.0], [47200.0, 1.0], [49600.0, 1.0], [49700.0, 1.0], [49500.0, 1.0], [51200.0, 1.0], [51400.0, 1.0], [55000.0, 1.0], [57300.0, 1.0], [58800.0, 1.0], [64800.0, 1.0], [68000.0, 1.0]], "isOverall": false, "label": "ALL POST\'s", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 100, "maxX": 68000.0, "title": "Response Time Distribution"}},
        getOptions: function() {
            var granularity = this.data.result.granularity;
            return {
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimeDistribution'
                },
                xaxis:{
                    axisLabel: "Response times in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of responses",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                bars : {
                    show: true,
                    barWidth: this.data.result.granularity
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: function(label, xval, yval, flotItem){
                        return yval + " responses for " + label + " were between " + xval + " and " + (xval + granularity) + " ms";
                    }
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimeDistribution"), prepareData(data.result.series, $("#choicesResponseTimeDistribution")), options);
        }

};

// Response time distribution
function refreshResponseTimeDistribution() {
    var infos = responseTimeDistributionInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimeDistribution");
        return;
    }
    if (isGraph($("#flotResponseTimeDistribution"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesResponseTimeDistribution");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        $('#footerResponseTimeDistribution .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var syntheticResponseTimeDistributionInfos = {
        data: {"result": {"minY": 2.0, "minX": 2.0, "ticks": [[0, "Requests having \nresponse time <= 500ms"], [1, "Requests having \nresponse time > 500ms and <= 1,500ms"], [2, "Requests having \nresponse time > 1,500ms"], [3, "Requests in error"]], "maxY": 77.0, "series": [{"data": [], "color": "#9ACD32", "isOverall": false, "label": "Requests having \nresponse time <= 500ms", "isController": false}, {"data": [], "color": "yellow", "isOverall": false, "label": "Requests having \nresponse time > 500ms and <= 1,500ms", "isController": false}, {"data": [[2.0, 77.0]], "color": "orange", "isOverall": false, "label": "Requests having \nresponse time > 1,500ms", "isController": false}, {"data": [[3.0, 2.0]], "color": "#FF6347", "isOverall": false, "label": "Requests in error", "isController": false}], "supportsControllersDiscrimination": false, "maxX": 3.0, "title": "Synthetic Response Times Distribution"}},
        getOptions: function() {
            return {
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendSyntheticResponseTimeDistribution'
                },
                xaxis:{
                    axisLabel: "Response times ranges",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                    tickLength:0,
                    min:-0.5,
                    max:3.5
                },
                yaxis: {
                    axisLabel: "Number of responses",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                bars : {
                    show: true,
                    align: "center",
                    barWidth: 0.25,
                    fill:.75
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: function(label, xval, yval, flotItem){
                        return yval + " " + label;
                    }
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var options = this.getOptions();
            prepareOptions(options, data);
            options.xaxis.ticks = data.result.ticks;
            $.plot($("#flotSyntheticResponseTimeDistribution"), prepareData(data.result.series, $("#choicesSyntheticResponseTimeDistribution")), options);
        }

};

// Response time distribution
function refreshSyntheticResponseTimeDistribution() {
    var infos = syntheticResponseTimeDistributionInfos;
    prepareSeries(infos.data, true);
    if (isGraph($("#flotSyntheticResponseTimeDistribution"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesSyntheticResponseTimeDistribution");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        $('#footerSyntheticResponseTimeDistribution .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var activeThreadsOverTimeInfos = {
        data: {"result": {"minY": 2.0, "minX": 1.60768806E12, "maxY": 2.0, "series": [{"data": [[1.60768812E12, 2.0], [1.60768872E12, 2.0], [1.60768974E12, 2.0], [1.60768842E12, 2.0], [1.60768962E12, 2.0], [1.60768902E12, 2.0], [1.60768932E12, 2.0], [1.60768926E12, 2.0], [1.60768824E12, 2.0], [1.60768956E12, 2.0], [1.60768884E12, 2.0], [1.60768854E12, 2.0], [1.60768944E12, 2.0], [1.60768914E12, 2.0], [1.60768908E12, 2.0], [1.60768938E12, 2.0], [1.60768878E12, 2.0], [1.60768968E12, 2.0], [1.60768836E12, 2.0], [1.60768806E12, 2.0], [1.60768896E12, 2.0], [1.60768866E12, 2.0], [1.6076886E12, 2.0], [1.6076883E12, 2.0], [1.6076892E12, 2.0], [1.6076889E12, 2.0], [1.60768848E12, 2.0], [1.6076895E12, 2.0], [1.60768818E12, 2.0], [1.6076898E12, 2.0]], "isOverall": false, "label": "CARREGAR POST\'s", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.6076898E12, "title": "Active Threads Over Time"}},
        getOptions: function() {
            return {
                series: {
                    stack: true,
                    lines: {
                        show: true,
                        fill: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of active threads",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 6,
                    show: true,
                    container: '#legendActiveThreadsOverTime'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                selection: {
                    mode: 'xy'
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : At %x there were %y active threads"
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesActiveThreadsOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotActiveThreadsOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewActiveThreadsOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Active Threads Over Time
function refreshActiveThreadsOverTime(fixTimestamps) {
    var infos = activeThreadsOverTimeInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotActiveThreadsOverTime"))) {
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesActiveThreadsOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotActiveThreadsOverTime", "#overviewActiveThreadsOverTime");
        $('#footerActiveThreadsOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var timeVsThreadsInfos = {
        data: {"result": {"minY": 46143.64556962025, "minX": 2.0, "maxY": 46143.64556962025, "series": [{"data": [[2.0, 46143.64556962025]], "isOverall": false, "label": "ALL POST\'s", "isController": false}, {"data": [[2.0, 46143.64556962025]], "isOverall": false, "label": "ALL POST\'s-Aggregated", "isController": false}], "supportsControllersDiscrimination": true, "maxX": 2.0, "title": "Time VS Threads"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    axisLabel: "Number of active threads",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average response times in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: { noColumns: 2,show: true, container: '#legendTimeVsThreads' },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s: At %x.2 active threads, Average response time was %y.2 ms"
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesTimeVsThreads"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotTimesVsThreads"), dataset, options);
            // setup overview
            $.plot($("#overviewTimesVsThreads"), dataset, prepareOverviewOptions(options));
        }
};

// Time vs threads
function refreshTimeVsThreads(){
    var infos = timeVsThreadsInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyTimeVsThreads");
        return;
    }
    if(isGraph($("#flotTimesVsThreads"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesTimeVsThreads");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTimesVsThreads", "#overviewTimesVsThreads");
        $('#footerTimeVsThreads .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var bytesThroughputOverTimeInfos = {
        data : {"result": {"minY": 0.0, "minX": 1.60768806E12, "maxY": 271337.3333333333, "series": [{"data": [[1.60768812E12, 135642.08333333334], [1.60768872E12, 203516.96666666667], [1.60768974E12, 271308.9], [1.60768842E12, 271310.9666666667], [1.60768962E12, 135636.71666666667], [1.60768902E12, 203461.85], [1.60768932E12, 203456.98333333334], [1.60768926E12, 135708.93333333332], [1.60768824E12, 271337.3333333333], [1.60768956E12, 203497.35], [1.60768884E12, 135635.03333333333], [1.60768854E12, 203494.36666666667], [1.60768944E12, 135665.28333333333], [1.60768914E12, 203452.13333333333], [1.60768908E12, 135680.0], [1.60768938E12, 203498.43333333332], [1.60768878E12, 203545.96666666667], [1.60768968E12, 135672.73333333334], [1.60768836E12, 135687.11666666667], [1.60768806E12, 271288.5833333333], [1.60768896E12, 135653.8], [1.60768866E12, 135648.21666666667], [1.6076886E12, 203508.58333333334], [1.6076883E12, 135643.26666666666], [1.6076892E12, 203492.31666666668], [1.6076889E12, 135695.21666666667], [1.60768848E12, 135674.91666666666], [1.6076895E12, 203473.6], [1.60768818E12, 135671.9], [1.6076898E12, 95.1]], "isOverall": false, "label": "Bytes received per second", "isController": false}, {"data": [[1.60768812E12, 6.1], [1.60768872E12, 9.15], [1.60768974E12, 12.2], [1.60768842E12, 12.2], [1.60768962E12, 6.1], [1.60768902E12, 9.15], [1.60768932E12, 9.15], [1.60768926E12, 6.1], [1.60768824E12, 12.2], [1.60768956E12, 9.15], [1.60768884E12, 6.1], [1.60768854E12, 9.15], [1.60768944E12, 6.1], [1.60768914E12, 9.15], [1.60768908E12, 6.1], [1.60768938E12, 9.15], [1.60768878E12, 9.15], [1.60768968E12, 6.1], [1.60768836E12, 6.1], [1.60768806E12, 12.2], [1.60768896E12, 6.1], [1.60768866E12, 6.1], [1.6076886E12, 9.15], [1.6076883E12, 6.1], [1.6076892E12, 9.15], [1.6076889E12, 6.1], [1.60768848E12, 6.1], [1.6076895E12, 9.15], [1.60768818E12, 6.1], [1.6076898E12, 0.0]], "isOverall": false, "label": "Bytes sent per second", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.6076898E12, "title": "Bytes Throughput Over Time"}},
        getOptions : function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity) ,
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Bytes / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendBytesThroughputOverTime'
                },
                selection: {
                    mode: "xy"
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y"
                }
            };
        },
        createGraph : function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesBytesThroughputOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotBytesThroughputOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewBytesThroughputOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Bytes throughput Over Time
function refreshBytesThroughputOverTime(fixTimestamps) {
    var infos = bytesThroughputOverTimeInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotBytesThroughputOverTime"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesBytesThroughputOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotBytesThroughputOverTime", "#overviewBytesThroughputOverTime");
        $('#footerBytesThroughputOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var responseTimesOverTimeInfos = {
        data: {"result": {"minY": 41967.0, "minX": 1.60768806E12, "maxY": 61563.0, "series": [{"data": [[1.60768812E12, 45862.5], [1.60768872E12, 43543.333333333336], [1.60768974E12, 47297.75], [1.60768842E12, 44474.5], [1.60768962E12, 45263.0], [1.60768902E12, 45429.333333333336], [1.60768932E12, 45281.666666666664], [1.60768926E12, 44576.5], [1.60768824E12, 44871.5], [1.60768956E12, 44755.333333333336], [1.60768884E12, 61563.0], [1.60768854E12, 43259.0], [1.60768944E12, 44509.5], [1.60768914E12, 52952.0], [1.60768908E12, 46047.0], [1.60768938E12, 45138.333333333336], [1.60768878E12, 43564.333333333336], [1.60768968E12, 45191.0], [1.60768836E12, 45932.5], [1.60768806E12, 44606.75], [1.60768896E12, 45630.0], [1.60768866E12, 46157.0], [1.6076886E12, 44868.0], [1.6076883E12, 45590.0], [1.6076892E12, 43746.666666666664], [1.6076889E12, 53827.5], [1.60768848E12, 45632.5], [1.6076895E12, 46748.666666666664], [1.60768818E12, 41967.0], [1.6076898E12, 53494.0]], "isOverall": false, "label": "ALL POST\'s", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.6076898E12, "title": "Response Time Over Time"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average response time in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimesOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Average response time was %y ms"
                }
            };
        },
        createGraph: function() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesResponseTimesOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimesOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewResponseTimesOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Response Times Over Time
function refreshResponseTimeOverTime(fixTimestamps) {
    var infos = responseTimesOverTimeInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyResponseTimeOverTime");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotResponseTimesOverTime"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesResponseTimesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimesOverTime", "#overviewResponseTimesOverTime");
        $('#footerResponseTimesOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var latenciesOverTimeInfos = {
        data: {"result": {"minY": 39838.5, "minX": 1.60768806E12, "maxY": 44675.5, "series": [{"data": [[1.60768812E12, 41446.5], [1.60768872E12, 40640.0], [1.60768974E12, 42526.25], [1.60768842E12, 41089.0], [1.60768962E12, 41991.5], [1.60768902E12, 41418.0], [1.60768932E12, 41620.666666666664], [1.60768926E12, 41196.5], [1.60768824E12, 40850.5], [1.60768956E12, 41466.333333333336], [1.60768884E12, 42086.5], [1.60768854E12, 40517.0], [1.60768944E12, 41270.0], [1.60768914E12, 42968.0], [1.60768908E12, 43168.0], [1.60768938E12, 42146.0], [1.60768878E12, 40763.0], [1.60768968E12, 41873.0], [1.60768836E12, 43675.0], [1.60768806E12, 41358.0], [1.60768896E12, 40795.0], [1.60768866E12, 41603.0], [1.6076886E12, 41818.333333333336], [1.6076883E12, 41310.0], [1.6076892E12, 40953.0], [1.6076889E12, 40775.5], [1.60768848E12, 41154.0], [1.6076895E12, 43317.0], [1.60768818E12, 39838.5], [1.6076898E12, 44675.5]], "isOverall": false, "label": "ALL POST\'s", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.6076898E12, "title": "Latencies Over Time"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average response latencies in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendLatenciesOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Average latency was %y ms"
                }
            };
        },
        createGraph: function () {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesLatenciesOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotLatenciesOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewLatenciesOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Latencies Over Time
function refreshLatenciesOverTime(fixTimestamps) {
    var infos = latenciesOverTimeInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyLatenciesOverTime");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotLatenciesOverTime"))) {
        infos.createGraph();
    }else {
        var choiceContainer = $("#choicesLatenciesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotLatenciesOverTime", "#overviewLatenciesOverTime");
        $('#footerLatenciesOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var connectTimeOverTimeInfos = {
        data: {"result": {"minY": 0.0, "minX": 1.60768806E12, "maxY": 1271.0, "series": [{"data": [[1.60768812E12, 1175.5], [1.60768872E12, 441.6666666666667], [1.60768974E12, 774.5], [1.60768842E12, 597.75], [1.60768962E12, 909.0], [1.60768902E12, 843.0], [1.60768932E12, 848.3333333333334], [1.60768926E12, 590.5], [1.60768824E12, 582.25], [1.60768956E12, 431.6666666666667], [1.60768884E12, 1194.0], [1.60768854E12, 440.6666666666667], [1.60768944E12, 616.5], [1.60768914E12, 1220.6666666666667], [1.60768908E12, 0.0], [1.60768938E12, 420.0], [1.60768878E12, 344.33333333333337], [1.60768968E12, 676.5], [1.60768836E12, 0.0], [1.60768806E12, 584.25], [1.60768896E12, 597.0], [1.60768866E12, 1271.0], [1.6076886E12, 346.0], [1.6076883E12, 1240.5], [1.6076892E12, 410.0], [1.6076889E12, 655.5], [1.60768848E12, 1189.0], [1.6076895E12, 888.0], [1.60768818E12, 0.0], [1.6076898E12, 704.5]], "isOverall": false, "label": "ALL POST\'s", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.6076898E12, "title": "Connect Time Over Time"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getConnectTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Average Connect Time in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendConnectTimeOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Average connect time was %y ms"
                }
            };
        },
        createGraph: function () {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesConnectTimeOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotConnectTimeOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewConnectTimeOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Connect Time Over Time
function refreshConnectTimeOverTime(fixTimestamps) {
    var infos = connectTimeOverTimeInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyConnectTimeOverTime");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotConnectTimeOverTime"))) {
        infos.createGraph();
    }else {
        var choiceContainer = $("#choicesConnectTimeOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotConnectTimeOverTime", "#overviewConnectTimeOverTime");
        $('#footerConnectTimeOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var responseTimePercentilesOverTimeInfos = {
        data: {"result": {"minY": 41670.0, "minX": 1.60768806E12, "maxY": 68042.0, "series": [{"data": [[1.60768812E12, 45966.0], [1.60768872E12, 46358.0], [1.60768974E12, 51416.0], [1.60768842E12, 47003.0], [1.60768962E12, 47687.0], [1.60768902E12, 47091.0], [1.60768932E12, 46536.0], [1.60768926E12, 46298.0], [1.60768824E12, 46587.0], [1.60768956E12, 46737.0], [1.60768884E12, 68042.0], [1.60768854E12, 45259.0], [1.60768944E12, 46525.0], [1.60768914E12, 64814.0], [1.60768908E12, 47171.0], [1.60768938E12, 49656.0], [1.60768878E12, 45844.0], [1.60768968E12, 47299.0], [1.60768836E12, 46091.0], [1.60768806E12, 47483.0], [1.60768896E12, 45669.0], [1.60768866E12, 46803.0], [1.6076886E12, 49093.0], [1.6076883E12, 45743.0], [1.6076892E12, 45844.0], [1.6076889E12, 58877.0], [1.60768848E12, 45792.0], [1.6076895E12, 51221.0], [1.60768818E12, 42226.0]], "isOverall": false, "label": "Max", "isController": false}, {"data": [[1.60768812E12, 45759.0], [1.60768872E12, 41670.0], [1.60768974E12, 43932.0], [1.60768842E12, 42212.0], [1.60768962E12, 42839.0], [1.60768902E12, 42539.0], [1.60768932E12, 43338.0], [1.60768926E12, 42855.0], [1.60768824E12, 42055.0], [1.60768956E12, 42772.0], [1.60768884E12, 55084.0], [1.60768854E12, 41938.0], [1.60768944E12, 42494.0], [1.60768914E12, 46503.0], [1.60768908E12, 44923.0], [1.60768938E12, 42756.0], [1.60768878E12, 42105.0], [1.60768968E12, 43083.0], [1.60768836E12, 45774.0], [1.60768806E12, 41997.0], [1.60768896E12, 45591.0], [1.60768866E12, 45511.0], [1.6076886E12, 42617.0], [1.6076883E12, 45437.0], [1.6076892E12, 42665.0], [1.6076889E12, 48778.0], [1.60768848E12, 45473.0], [1.6076895E12, 43021.0], [1.60768818E12, 41708.0]], "isOverall": false, "label": "90th percentile", "isController": false}, {"data": [[1.60768812E12, 45759.0], [1.60768872E12, 41670.0], [1.60768974E12, 43932.0], [1.60768842E12, 42212.0], [1.60768962E12, 42839.0], [1.60768902E12, 42539.0], [1.60768932E12, 43338.0], [1.60768926E12, 42855.0], [1.60768824E12, 42055.0], [1.60768956E12, 42772.0], [1.60768884E12, 55084.0], [1.60768854E12, 41938.0], [1.60768944E12, 42494.0], [1.60768914E12, 46503.0], [1.60768908E12, 44923.0], [1.60768938E12, 42756.0], [1.60768878E12, 42105.0], [1.60768968E12, 43083.0], [1.60768836E12, 45774.0], [1.60768806E12, 41997.0], [1.60768896E12, 45591.0], [1.60768866E12, 45511.0], [1.6076886E12, 42617.0], [1.6076883E12, 45437.0], [1.6076892E12, 42665.0], [1.6076889E12, 48778.0], [1.60768848E12, 45473.0], [1.6076895E12, 43021.0], [1.60768818E12, 41708.0]], "isOverall": false, "label": "99th percentile", "isController": false}, {"data": [[1.60768812E12, 45759.0], [1.60768872E12, 41670.0], [1.60768974E12, 43932.0], [1.60768842E12, 42212.0], [1.60768962E12, 42839.0], [1.60768902E12, 42539.0], [1.60768932E12, 43338.0], [1.60768926E12, 42855.0], [1.60768824E12, 42055.0], [1.60768956E12, 42772.0], [1.60768884E12, 55084.0], [1.60768854E12, 41938.0], [1.60768944E12, 42494.0], [1.60768914E12, 46503.0], [1.60768908E12, 44923.0], [1.60768938E12, 42756.0], [1.60768878E12, 42105.0], [1.60768968E12, 43083.0], [1.60768836E12, 45774.0], [1.60768806E12, 41997.0], [1.60768896E12, 45591.0], [1.60768866E12, 45511.0], [1.6076886E12, 42617.0], [1.6076883E12, 45437.0], [1.6076892E12, 42665.0], [1.6076889E12, 48778.0], [1.60768848E12, 45473.0], [1.6076895E12, 43021.0], [1.60768818E12, 41708.0]], "isOverall": false, "label": "95th percentile", "isController": false}, {"data": [[1.60768812E12, 45759.0], [1.60768872E12, 41670.0], [1.60768974E12, 43932.0], [1.60768842E12, 42212.0], [1.60768962E12, 42839.0], [1.60768902E12, 42539.0], [1.60768932E12, 43338.0], [1.60768926E12, 42855.0], [1.60768824E12, 42055.0], [1.60768956E12, 42772.0], [1.60768884E12, 55084.0], [1.60768854E12, 41938.0], [1.60768944E12, 42494.0], [1.60768914E12, 46503.0], [1.60768908E12, 44923.0], [1.60768938E12, 42756.0], [1.60768878E12, 42105.0], [1.60768968E12, 43083.0], [1.60768836E12, 45774.0], [1.60768806E12, 41997.0], [1.60768896E12, 45591.0], [1.60768866E12, 45511.0], [1.6076886E12, 42617.0], [1.6076883E12, 45437.0], [1.6076892E12, 42665.0], [1.6076889E12, 48778.0], [1.60768848E12, 45473.0], [1.6076895E12, 43021.0], [1.60768818E12, 41708.0]], "isOverall": false, "label": "Min", "isController": false}, {"data": [[1.60768812E12, 45862.5], [1.60768872E12, 42602.0], [1.60768974E12, 46921.5], [1.60768842E12, 44341.5], [1.60768962E12, 45263.0], [1.60768902E12, 46658.0], [1.60768932E12, 45971.0], [1.60768926E12, 44576.5], [1.60768824E12, 45422.0], [1.60768956E12, 44757.0], [1.60768884E12, 61563.0], [1.60768854E12, 42580.0], [1.60768944E12, 44509.5], [1.60768914E12, 47539.0], [1.60768908E12, 46047.0], [1.60768938E12, 43003.0], [1.60768878E12, 42744.0], [1.60768968E12, 45191.0], [1.60768836E12, 45932.5], [1.60768806E12, 44473.5], [1.60768896E12, 45630.0], [1.60768866E12, 46157.0], [1.6076886E12, 42894.0], [1.6076883E12, 45590.0], [1.6076892E12, 42731.0], [1.6076889E12, 53827.5], [1.60768848E12, 45632.5], [1.6076895E12, 46004.0], [1.60768818E12, 41967.0]], "isOverall": false, "label": "Median", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.60768974E12, "title": "Response Time Percentiles Over Time (successful requests only)"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true,
                        fill: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Response Time in ms",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: '#legendResponseTimePercentilesOverTime'
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s : at %x Response time was %y ms"
                }
            };
        },
        createGraph: function () {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesResponseTimePercentilesOverTime"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotResponseTimePercentilesOverTime"), dataset, options);
            // setup overview
            $.plot($("#overviewResponseTimePercentilesOverTime"), dataset, prepareOverviewOptions(options));
        }
};

// Response Time Percentiles Over Time
function refreshResponseTimePercentilesOverTime(fixTimestamps) {
    var infos = responseTimePercentilesOverTimeInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotResponseTimePercentilesOverTime"))) {
        infos.createGraph();
    }else {
        var choiceContainer = $("#choicesResponseTimePercentilesOverTime");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimePercentilesOverTime", "#overviewResponseTimePercentilesOverTime");
        $('#footerResponseTimePercentilesOverTime .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var responseTimeVsRequestInfos = {
    data: {"result": {"minY": 45743.0, "minX": 1.0, "maxY": 53494.0, "series": [{"data": [[1.0, 45743.0], [2.0, 46844.0]], "isOverall": false, "label": "Successes", "isController": false}, {"data": [[2.0, 53494.0]], "isOverall": false, "label": "Failures", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 1000, "maxX": 2.0, "title": "Response Time Vs Request"}},
    getOptions: function() {
        return {
            series: {
                lines: {
                    show: false
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                axisLabel: "Global number of requests per second",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Median Response Time in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: {
                noColumns: 2,
                show: true,
                container: '#legendResponseTimeVsRequest'
            },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : Median response time at %x req/s was %y ms"
            },
            colors: ["#9ACD32", "#FF6347"]
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesResponseTimeVsRequest"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotResponseTimeVsRequest"), dataset, options);
        // setup overview
        $.plot($("#overviewResponseTimeVsRequest"), dataset, prepareOverviewOptions(options));

    }
};

// Response Time vs Request
function refreshResponseTimeVsRequest() {
    var infos = responseTimeVsRequestInfos;
    prepareSeries(infos.data);
    if (isGraph($("#flotResponseTimeVsRequest"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesResponseTimeVsRequest");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotResponseTimeVsRequest", "#overviewResponseTimeVsRequest");
        $('#footerResponseRimeVsRequest .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};


var latenciesVsRequestInfos = {
    data: {"result": {"minY": 41427.0, "minX": 1.0, "maxY": 44675.5, "series": [{"data": [[1.0, 41427.0], [2.0, 41781.0]], "isOverall": false, "label": "Successes", "isController": false}, {"data": [[2.0, 44675.5]], "isOverall": false, "label": "Failures", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 1000, "maxX": 2.0, "title": "Latencies Vs Request"}},
    getOptions: function() {
        return{
            series: {
                lines: {
                    show: false
                },
                points: {
                    show: true
                }
            },
            xaxis: {
                axisLabel: "Global number of requests per second",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            yaxis: {
                axisLabel: "Median Latency in ms",
                axisLabelUseCanvas: true,
                axisLabelFontSizePixels: 12,
                axisLabelFontFamily: 'Verdana, Arial',
                axisLabelPadding: 20,
            },
            legend: { noColumns: 2,show: true, container: '#legendLatencyVsRequest' },
            selection: {
                mode: 'xy'
            },
            grid: {
                hoverable: true // IMPORTANT! this is needed for tooltip to work
            },
            tooltip: true,
            tooltipOpts: {
                content: "%s : Median Latency time at %x req/s was %y ms"
            },
            colors: ["#9ACD32", "#FF6347"]
        };
    },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesLatencyVsRequest"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotLatenciesVsRequest"), dataset, options);
        // setup overview
        $.plot($("#overviewLatenciesVsRequest"), dataset, prepareOverviewOptions(options));
    }
};

// Latencies vs Request
function refreshLatenciesVsRequest() {
        var infos = latenciesVsRequestInfos;
        prepareSeries(infos.data);
        if(isGraph($("#flotLatenciesVsRequest"))){
            infos.createGraph();
        }else{
            var choiceContainer = $("#choicesLatencyVsRequest");
            createLegend(choiceContainer, infos);
            infos.createGraph();
            setGraphZoomable("#flotLatenciesVsRequest", "#overviewLatenciesVsRequest");
            $('#footerLatenciesVsRequest .legendColorBox > div').each(function(i){
                $(this).clone().prependTo(choiceContainer.find("li").eq(i));
            });
        }
};

var hitsPerSecondInfos = {
        data: {"result": {"minY": 0.03333333333333333, "minX": 1.607688E12, "maxY": 0.06666666666666667, "series": [{"data": [[1.60768812E12, 0.03333333333333333], [1.60768872E12, 0.05], [1.60768974E12, 0.06666666666666667], [1.60768842E12, 0.06666666666666667], [1.60768962E12, 0.03333333333333333], [1.60768902E12, 0.05], [1.607688E12, 0.03333333333333333], [1.60768932E12, 0.05], [1.60768926E12, 0.03333333333333333], [1.60768824E12, 0.06666666666666667], [1.60768956E12, 0.05], [1.60768884E12, 0.03333333333333333], [1.60768854E12, 0.05], [1.60768944E12, 0.03333333333333333], [1.60768914E12, 0.05], [1.60768908E12, 0.03333333333333333], [1.60768938E12, 0.05], [1.60768878E12, 0.05], [1.60768968E12, 0.03333333333333333], [1.60768836E12, 0.03333333333333333], [1.60768806E12, 0.06666666666666667], [1.60768896E12, 0.03333333333333333], [1.60768866E12, 0.03333333333333333], [1.6076886E12, 0.05], [1.6076883E12, 0.03333333333333333], [1.6076892E12, 0.05], [1.6076889E12, 0.03333333333333333], [1.60768848E12, 0.03333333333333333], [1.6076895E12, 0.05], [1.60768818E12, 0.03333333333333333]], "isOverall": false, "label": "hitsPerSecond", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.60768974E12, "title": "Hits Per Second"}},
        getOptions: function() {
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of hits / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendHitsPerSecond"
                },
                selection: {
                    mode : 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y.2 hits/sec"
                }
            };
        },
        createGraph: function createGraph() {
            var data = this.data;
            var dataset = prepareData(data.result.series, $("#choicesHitsPerSecond"));
            var options = this.getOptions();
            prepareOptions(options, data);
            $.plot($("#flotHitsPerSecond"), dataset, options);
            // setup overview
            $.plot($("#overviewHitsPerSecond"), dataset, prepareOverviewOptions(options));
        }
};

// Hits per second
function refreshHitsPerSecond(fixTimestamps) {
    var infos = hitsPerSecondInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if (isGraph($("#flotHitsPerSecond"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesHitsPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotHitsPerSecond", "#overviewHitsPerSecond");
        $('#footerHitsPerSecond .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
}

var codesPerSecondInfos = {
        data: {"result": {"minY": 0.03333333333333333, "minX": 1.60768806E12, "maxY": 0.06666666666666667, "series": [{"data": [[1.6076898E12, 0.03333333333333333]], "isOverall": false, "label": "Non HTTP response code: javax.net.ssl.SSLException", "isController": false}, {"data": [[1.60768812E12, 0.03333333333333333], [1.60768872E12, 0.05], [1.60768974E12, 0.06666666666666667], [1.60768842E12, 0.06666666666666667], [1.60768962E12, 0.03333333333333333], [1.60768902E12, 0.05], [1.60768932E12, 0.05], [1.60768926E12, 0.03333333333333333], [1.60768824E12, 0.06666666666666667], [1.60768956E12, 0.05], [1.60768884E12, 0.03333333333333333], [1.60768854E12, 0.05], [1.60768944E12, 0.03333333333333333], [1.60768914E12, 0.05], [1.60768908E12, 0.03333333333333333], [1.60768938E12, 0.05], [1.60768878E12, 0.05], [1.60768968E12, 0.03333333333333333], [1.60768836E12, 0.03333333333333333], [1.60768806E12, 0.06666666666666667], [1.60768896E12, 0.03333333333333333], [1.60768866E12, 0.03333333333333333], [1.6076886E12, 0.05], [1.6076883E12, 0.03333333333333333], [1.6076892E12, 0.05], [1.6076889E12, 0.03333333333333333], [1.60768848E12, 0.03333333333333333], [1.6076895E12, 0.05], [1.60768818E12, 0.03333333333333333]], "isOverall": false, "label": "200", "isController": false}], "supportsControllersDiscrimination": false, "granularity": 60000, "maxX": 1.6076898E12, "title": "Codes Per Second"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of responses / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendCodesPerSecond"
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "Number of Response Codes %s at %x was %y.2 responses / sec"
                }
            };
        },
    createGraph: function() {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesCodesPerSecond"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotCodesPerSecond"), dataset, options);
        // setup overview
        $.plot($("#overviewCodesPerSecond"), dataset, prepareOverviewOptions(options));
    }
};

// Codes per second
function refreshCodesPerSecond(fixTimestamps) {
    var infos = codesPerSecondInfos;
    prepareSeries(infos.data);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotCodesPerSecond"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesCodesPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotCodesPerSecond", "#overviewCodesPerSecond");
        $('#footerCodesPerSecond .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var transactionsPerSecondInfos = {
        data: {"result": {"minY": 0.03333333333333333, "minX": 1.60768806E12, "maxY": 0.06666666666666667, "series": [{"data": [[1.6076898E12, 0.03333333333333333]], "isOverall": false, "label": "ALL POST\'s-failure", "isController": false}, {"data": [[1.60768812E12, 0.03333333333333333], [1.60768872E12, 0.05], [1.60768974E12, 0.06666666666666667], [1.60768842E12, 0.06666666666666667], [1.60768962E12, 0.03333333333333333], [1.60768902E12, 0.05], [1.60768932E12, 0.05], [1.60768926E12, 0.03333333333333333], [1.60768824E12, 0.06666666666666667], [1.60768956E12, 0.05], [1.60768884E12, 0.03333333333333333], [1.60768854E12, 0.05], [1.60768944E12, 0.03333333333333333], [1.60768914E12, 0.05], [1.60768908E12, 0.03333333333333333], [1.60768938E12, 0.05], [1.60768878E12, 0.05], [1.60768968E12, 0.03333333333333333], [1.60768836E12, 0.03333333333333333], [1.60768806E12, 0.06666666666666667], [1.60768896E12, 0.03333333333333333], [1.60768866E12, 0.03333333333333333], [1.6076886E12, 0.05], [1.6076883E12, 0.03333333333333333], [1.6076892E12, 0.05], [1.6076889E12, 0.03333333333333333], [1.60768848E12, 0.03333333333333333], [1.6076895E12, 0.05], [1.60768818E12, 0.03333333333333333]], "isOverall": false, "label": "ALL POST\'s-success", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.6076898E12, "title": "Transactions Per Second"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of transactions / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendTransactionsPerSecond"
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y transactions / sec"
                }
            };
        },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesTransactionsPerSecond"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotTransactionsPerSecond"), dataset, options);
        // setup overview
        $.plot($("#overviewTransactionsPerSecond"), dataset, prepareOverviewOptions(options));
    }
};

// Transactions per second
function refreshTransactionsPerSecond(fixTimestamps) {
    var infos = transactionsPerSecondInfos;
    prepareSeries(infos.data);
    if(infos.data.result.series.length == 0) {
        setEmptyGraph("#bodyTransactionsPerSecond");
        return;
    }
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotTransactionsPerSecond"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesTransactionsPerSecond");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTransactionsPerSecond", "#overviewTransactionsPerSecond");
        $('#footerTransactionsPerSecond .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

var totalTPSInfos = {
        data: {"result": {"minY": 0.03333333333333333, "minX": 1.60768806E12, "maxY": 0.06666666666666667, "series": [{"data": [[1.60768812E12, 0.03333333333333333], [1.60768872E12, 0.05], [1.60768974E12, 0.06666666666666667], [1.60768842E12, 0.06666666666666667], [1.60768962E12, 0.03333333333333333], [1.60768902E12, 0.05], [1.60768932E12, 0.05], [1.60768926E12, 0.03333333333333333], [1.60768824E12, 0.06666666666666667], [1.60768956E12, 0.05], [1.60768884E12, 0.03333333333333333], [1.60768854E12, 0.05], [1.60768944E12, 0.03333333333333333], [1.60768914E12, 0.05], [1.60768908E12, 0.03333333333333333], [1.60768938E12, 0.05], [1.60768878E12, 0.05], [1.60768968E12, 0.03333333333333333], [1.60768836E12, 0.03333333333333333], [1.60768806E12, 0.06666666666666667], [1.60768896E12, 0.03333333333333333], [1.60768866E12, 0.03333333333333333], [1.6076886E12, 0.05], [1.6076883E12, 0.03333333333333333], [1.6076892E12, 0.05], [1.6076889E12, 0.03333333333333333], [1.60768848E12, 0.03333333333333333], [1.6076895E12, 0.05], [1.60768818E12, 0.03333333333333333]], "isOverall": false, "label": "Transaction-success", "isController": false}, {"data": [[1.6076898E12, 0.03333333333333333]], "isOverall": false, "label": "Transaction-failure", "isController": false}], "supportsControllersDiscrimination": true, "granularity": 60000, "maxX": 1.6076898E12, "title": "Total Transactions Per Second"}},
        getOptions: function(){
            return {
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                xaxis: {
                    mode: "time",
                    timeformat: getTimeFormat(this.data.result.granularity),
                    axisLabel: getElapsedTimeLabel(this.data.result.granularity),
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20,
                },
                yaxis: {
                    axisLabel: "Number of transactions / sec",
                    axisLabelUseCanvas: true,
                    axisLabelFontSizePixels: 12,
                    axisLabelFontFamily: 'Verdana, Arial',
                    axisLabelPadding: 20
                },
                legend: {
                    noColumns: 2,
                    show: true,
                    container: "#legendTotalTPS"
                },
                selection: {
                    mode: 'xy'
                },
                grid: {
                    hoverable: true // IMPORTANT! this is needed for tooltip to
                                    // work
                },
                tooltip: true,
                tooltipOpts: {
                    content: "%s at %x was %y transactions / sec"
                },
                colors: ["#9ACD32", "#FF6347"]
            };
        },
    createGraph: function () {
        var data = this.data;
        var dataset = prepareData(data.result.series, $("#choicesTotalTPS"));
        var options = this.getOptions();
        prepareOptions(options, data);
        $.plot($("#flotTotalTPS"), dataset, options);
        // setup overview
        $.plot($("#overviewTotalTPS"), dataset, prepareOverviewOptions(options));
    }
};

// Total Transactions per second
function refreshTotalTPS(fixTimestamps) {
    var infos = totalTPSInfos;
    // We want to ignore seriesFilter
    prepareSeries(infos.data, false, true);
    if(fixTimestamps) {
        fixTimeStamps(infos.data.result.series, -10800000);
    }
    if(isGraph($("#flotTotalTPS"))){
        infos.createGraph();
    }else{
        var choiceContainer = $("#choicesTotalTPS");
        createLegend(choiceContainer, infos);
        infos.createGraph();
        setGraphZoomable("#flotTotalTPS", "#overviewTotalTPS");
        $('#footerTotalTPS .legendColorBox > div').each(function(i){
            $(this).clone().prependTo(choiceContainer.find("li").eq(i));
        });
    }
};

// Collapse the graph matching the specified DOM element depending the collapsed
// status
function collapse(elem, collapsed){
    if(collapsed){
        $(elem).parent().find(".fa-chevron-up").removeClass("fa-chevron-up").addClass("fa-chevron-down");
    } else {
        $(elem).parent().find(".fa-chevron-down").removeClass("fa-chevron-down").addClass("fa-chevron-up");
        if (elem.id == "bodyBytesThroughputOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshBytesThroughputOverTime(true);
            }
            document.location.href="#bytesThroughputOverTime";
        } else if (elem.id == "bodyLatenciesOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshLatenciesOverTime(true);
            }
            document.location.href="#latenciesOverTime";
        } else if (elem.id == "bodyCustomGraph") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshCustomGraph(true);
            }
            document.location.href="#responseCustomGraph";
        } else if (elem.id == "bodyConnectTimeOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshConnectTimeOverTime(true);
            }
            document.location.href="#connectTimeOverTime";
        } else if (elem.id == "bodyResponseTimePercentilesOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimePercentilesOverTime(true);
            }
            document.location.href="#responseTimePercentilesOverTime";
        } else if (elem.id == "bodyResponseTimeDistribution") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimeDistribution();
            }
            document.location.href="#responseTimeDistribution" ;
        } else if (elem.id == "bodySyntheticResponseTimeDistribution") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshSyntheticResponseTimeDistribution();
            }
            document.location.href="#syntheticResponseTimeDistribution" ;
        } else if (elem.id == "bodyActiveThreadsOverTime") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshActiveThreadsOverTime(true);
            }
            document.location.href="#activeThreadsOverTime";
        } else if (elem.id == "bodyTimeVsThreads") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTimeVsThreads();
            }
            document.location.href="#timeVsThreads" ;
        } else if (elem.id == "bodyCodesPerSecond") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshCodesPerSecond(true);
            }
            document.location.href="#codesPerSecond";
        } else if (elem.id == "bodyTransactionsPerSecond") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTransactionsPerSecond(true);
            }
            document.location.href="#transactionsPerSecond";
        } else if (elem.id == "bodyTotalTPS") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshTotalTPS(true);
            }
            document.location.href="#totalTPS";
        } else if (elem.id == "bodyResponseTimeVsRequest") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshResponseTimeVsRequest();
            }
            document.location.href="#responseTimeVsRequest";
        } else if (elem.id == "bodyLatenciesVsRequest") {
            if (isGraph($(elem).find('.flot-chart-content')) == false) {
                refreshLatenciesVsRequest();
            }
            document.location.href="#latencyVsRequest";
        }
    }
}

/*
 * Activates or deactivates all series of the specified graph (represented by id parameter)
 * depending on checked argument.
 */
function toggleAll(id, checked){
    var placeholder = document.getElementById(id);

    var cases = $(placeholder).find(':checkbox');
    cases.prop('checked', checked);
    $(cases).parent().children().children().toggleClass("legend-disabled", !checked);

    var choiceContainer;
    if ( id == "choicesBytesThroughputOverTime"){
        choiceContainer = $("#choicesBytesThroughputOverTime");
        refreshBytesThroughputOverTime(false);
    } else if(id == "choicesResponseTimesOverTime"){
        choiceContainer = $("#choicesResponseTimesOverTime");
        refreshResponseTimeOverTime(false);
    }else if(id == "choicesResponseCustomGraph"){
        choiceContainer = $("#choicesResponseCustomGraph");
        refreshCustomGraph(false);
    } else if ( id == "choicesLatenciesOverTime"){
        choiceContainer = $("#choicesLatenciesOverTime");
        refreshLatenciesOverTime(false);
    } else if ( id == "choicesConnectTimeOverTime"){
        choiceContainer = $("#choicesConnectTimeOverTime");
        refreshConnectTimeOverTime(false);
    } else if ( id == "choicesResponseTimePercentilesOverTime"){
        choiceContainer = $("#choicesResponseTimePercentilesOverTime");
        refreshResponseTimePercentilesOverTime(false);
    } else if ( id == "choicesResponseTimePercentiles"){
        choiceContainer = $("#choicesResponseTimePercentiles");
        refreshResponseTimePercentiles();
    } else if(id == "choicesActiveThreadsOverTime"){
        choiceContainer = $("#choicesActiveThreadsOverTime");
        refreshActiveThreadsOverTime(false);
    } else if ( id == "choicesTimeVsThreads"){
        choiceContainer = $("#choicesTimeVsThreads");
        refreshTimeVsThreads();
    } else if ( id == "choicesSyntheticResponseTimeDistribution"){
        choiceContainer = $("#choicesSyntheticResponseTimeDistribution");
        refreshSyntheticResponseTimeDistribution();
    } else if ( id == "choicesResponseTimeDistribution"){
        choiceContainer = $("#choicesResponseTimeDistribution");
        refreshResponseTimeDistribution();
    } else if ( id == "choicesHitsPerSecond"){
        choiceContainer = $("#choicesHitsPerSecond");
        refreshHitsPerSecond(false);
    } else if(id == "choicesCodesPerSecond"){
        choiceContainer = $("#choicesCodesPerSecond");
        refreshCodesPerSecond(false);
    } else if ( id == "choicesTransactionsPerSecond"){
        choiceContainer = $("#choicesTransactionsPerSecond");
        refreshTransactionsPerSecond(false);
    } else if ( id == "choicesTotalTPS"){
        choiceContainer = $("#choicesTotalTPS");
        refreshTotalTPS(false);
    } else if ( id == "choicesResponseTimeVsRequest"){
        choiceContainer = $("#choicesResponseTimeVsRequest");
        refreshResponseTimeVsRequest();
    } else if ( id == "choicesLatencyVsRequest"){
        choiceContainer = $("#choicesLatencyVsRequest");
        refreshLatenciesVsRequest();
    }
    var color = checked ? "black" : "#818181";
    if(choiceContainer != null) {
        choiceContainer.find("label").each(function(){
            this.style.color = color;
        });
    }
}

