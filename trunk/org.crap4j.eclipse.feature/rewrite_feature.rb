#!/usr/bin/env ruby

class FileUpdater

  def rewrite_feature_xml(crap4j_version, juf_version, from_file, to_file)
    original_site_xml = File.read(from_file)
    updated_site_xml = original_site_xml.gsub("0.1.13",crap4j_version)
    updated_site_xml = updated_site_xml.gsub("2.0.0.000495",juf_version)
    File.open(to_file, 'w+') { |f| f.puts updated_site_xml }
  end

end

if $0 == __FILE__
  FileUpdater.new.rewrite_feature_xml(ARGV[0], ARGV[1], ARGV[2], ARGV[3])
end
#version_numbers = File.read("build.number").split()
#numbers=version_numbers.map { |n| n.split("=").last }
#version_number = numbers.join(".")

#juf_version_number = "2.0.0.000500"




