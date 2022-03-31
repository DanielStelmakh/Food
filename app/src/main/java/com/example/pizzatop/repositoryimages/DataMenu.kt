package com.example.pizzatop.repositoryimages

class DataMenu:Image {
    private val position1="https://i.ibb.co/f9cvz6T/77-e1620050430774.jpg"
    private val position2="https://i.ibb.co/HBWW2Kd/307.jpg"
    private val position3="https://i.ibb.co/2sBfWgR/f4b964a2.jpg"
    private val position4="https://i.ibb.co/yVMH2LY/1367863689.jpg"
    private val position5="https://i.ibb.co/vxLqLnY/scale-1200-6.jpg"
    private val position6="https://i.ibb.co/GpCPFsw/pizza-salad1-1200x900.jpg"
    private val position7="https://i.ibb.co/WvbXTSc/scale-1200-5.jpg"
    override fun returnList(): ArrayList<String> {
        val listMenu=ArrayList<String>()
        listMenu.add(position1)
        listMenu.add(position2)
        listMenu.add(position3)
        listMenu.add(position4)
        listMenu.add(position5)
        listMenu.add(position6)
        listMenu.add(position7)
        return listMenu
    }

}