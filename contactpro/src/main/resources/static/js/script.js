console.log("script loaded");

let currentTheme = getTheme();

document.addEventListener("DOMContentLoaded",()=>{
    changeTheme(currentTheme);
})

function changeTheme(){
    //set to web page
    document.querySelector('html').classList.add(currentTheme);

    //set listener to change theme button
    const changeThemeButton = document.querySelector('#theme_change_button');
    changeThemeButton.addEventListener("click", ()=> {
        //change the text of button
        changeThemeButton.querySelector('span').textContent = currentTheme == 'light' ? 'Dark' : 'Light';
        const oldTheme = currentTheme;
        console.log("Change theme button clicked");
        if(currentTheme === "dark"){
            //theme to light
            currentTheme = "light";
        }else{
            //theme to dark
            currentTheme = "dark";
        }
        //update local storage
        setTheme(currentTheme);
        //remove the current theme
        document.querySelector('html').classList.remove(oldTheme);
        //set the current theme
        document.querySelector('html').classList.add(currentTheme);

        //change the text of button
        changeThemeButton.querySelector('span').textContent = currentTheme == 'light' ? 'Dark' : 'Light';

    })
}

//set theme to localstorage
function setTheme(theme){
    localStorage.setItem("theme", theme);
}

//get theme from local storage
function getTheme(){
    let theme = localStorage.getItem("theme");
    if(theme){
        return theme;
    }else{
        return "light";
    }
}