/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var searchInput = document.getElementById("search-input");
var searchBtn = document.getElementById("search-btn");
var errorEl = document.getElementById("error");
var inputValue = searchInput.value.trim();

function input() {
    if (inputValue.length > 100) {
        searchBtn.setAttribute("disabled", "disabled");
        errorEl.innerHTML = "Text Length is over 100 characters!";
    } else {
        searchBtn.removeAttribute("disabled");
        errorEl.innerHTML = "";
    }
}

function formSubmit() {
    searchInput.value = searchInput.value.trim();
}
