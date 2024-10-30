package com.example.samuraitravel.controller

import com.example.samuraitravel.service.HouseService
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/admin/houses")
class AdminHouseController /* Constructor */(private val houseService: HouseService) {
    @GetMapping
    fun index(
        @RequestParam(name = "keyword", required = false) keyword: String?,
        @PageableDefault(page = 0, size = 10, sort = ["id"], direction = Sort.Direction.ASC) pageable: Pageable?,
        model: Model
    ): String {
        val housePage = if (!keyword.isNullOrEmpty()) {
            houseService.findHousesByNameLike(keyword, pageable)
        } else {
            if (pageable != null) {
                houseService.findAllHouses(pageable)
            } else {
                return ""
            }
        }

        model.addAttribute("housePage", housePage)
        model.addAttribute("keyword", keyword)

        return "admin/houses/index"
    }
}
