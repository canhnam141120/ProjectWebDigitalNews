/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function pagger(paggerId, keyword, pageIndex, totalPages) {
    var paggerEl = document.getElementById(paggerId);
    for (var i = 1; i <= totalPages; i++) {
        var child = document.createElement("li");
        if (i === pageIndex) {
            var current = document.createElement("span");
            current.innerHTML = pageIndex;
            child.appendChild(current);
        } else {
            var link = document.createElement("a");
            link.href = '?keyword=' + keyword + '&page=' + i;
            link.innerHTML = i;
            child.appendChild(link);
        }
        paggerEl.appendChild(child);
    }
}


