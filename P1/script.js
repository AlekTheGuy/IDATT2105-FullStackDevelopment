function incrementValue() {
    let i = parseInt(document.getElementById("value").innerHTML);
    document.getElementById("value").innerHTML = ++i;
}

function hideText() {
    document.getElementById("copyright").style.display="none"
}

function addOptions() {
    let menuElements = ["test", "kult", "veldig kult", "liste"]

    menuElements.forEach(element => {
        let node = document.createElement("li");
        let textNode = document.createTextNode(element);
        node.appendChild(textNode);
        document.getElementById("list").appendChild(node);
    });

}

function changeColors() {
    
}
