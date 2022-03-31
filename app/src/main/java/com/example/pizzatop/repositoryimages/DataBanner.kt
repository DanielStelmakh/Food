package com.example.pizzatop.repositoryimages

class DataBanner:Image {
    private val firstBannerURL="https://i.ibb.co/Pryd1Mx/1626868980-7-p-krasnii-fon-s-pitstsei-10.jpg"
    private val secondBannerURL="https://i.ibb.co/n0gTMCX/1619141087-15-phonoteka-org-p-pitstsa-fon-23.jpg"
    private val thirdBannerURL ="https://i.ibb.co/vhfqPQK/1625579460-33-phonoteka-org-p-pitstsa-zastavka-krasivie-zastavki-34.jpg"
    override fun returnList():ArrayList<String>{
         val listBanner=ArrayList<String>()
        listBanner.add(firstBannerURL)
        listBanner.add(secondBannerURL)
        listBanner.add(thirdBannerURL)
        return listBanner
    }



}