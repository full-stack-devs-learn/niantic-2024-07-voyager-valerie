package com.niantic;

import com.niantic.models.Vendor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.util.ArrayList;

public class VendorDao
{
    JdbcTemplate jdbcTemplate;

    public ArrayList<Vendor> getAllVendors()
    {
        var vendors = new ArrayList<Vendor>();

        String sql = """
                SELECT vendor_id
                    , vendor_name
                    , website
                FROM vendors;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            int vendorId = row.getInt("vendor_id");
            String vendorName = row.getString("vendor_name");
            String website = row.getString("website");

            Vendor vendor = new Vendor();

            vendor.setVendorId(vendorId);
            vendor.setVendorName(vendorName);
            vendor.setWebsite(website);

            vendors.add(vendor);
        }

        return vendors;
    }

    public Vendor getVendorById(int vendorId)
    {
        var vendor = new Vendor();

        String sql = """
                SELECT vendor_id
                    , vendor_name
                    , website
                FROM vendors
                WHERE vendor_id = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, vendorId);

        int vendorsId = row.getInt("vendorId");
        String vendorName = row.getString("vendor_name");
        String website = row.getString("website");

        vendor.setVendorId(vendorsId);
        vendor.setVendorName(vendorName);
        vendor.setWebsite(website);

        return vendor;
    }

    public Vendor getVendorByName(String name)
    {
        var vendor = new Vendor();

        String sql = """
                SELECT vendor_id
                    , vendor_name
                    , website
                FROM vendors
                WHERE vendor_name = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, name);

        int vendorId = row.getInt("vendorId");
        String vendorName = row.getString("vendor_name");
        String website = row.getString("website");

        vendor.setVendorId(vendorId);
        vendor.setVendorName(vendorName);
        vendor.setWebsite(website);

        return vendor;
    }

    public void addVendor(Vendor vendor)
    {
        String sql = """
                INSERT INTO vendors(vendor_id
                    , vendor_name
                    , website
                VALUES(?, ?, ?);
                """;

        jdbcTemplate.update(sql,
                vendor.getVendorId(),
                vendor.getVendorName(),
                vendor.getWebsite());
    }

    public void updateVendor(Vendor vendor)
    {
        String sql = """
                UPDATE vendors
                SET vendor_id
                    , vendor_name
                    , website
                WHERE vendor_id = ?;
                """;

        jdbcTemplate.update(sql,
                vendor.getVendorId(),
                vendor.getVendorName(),
                vendor.getWebsite());
    }

    public void deleteVendor(int vendorId)
    {
        String sql = """
                DELETE FROM vendors
                WHERE vendor_id = ?;
                """;

        jdbcTemplate.update(sql, vendorId);
    }
}
